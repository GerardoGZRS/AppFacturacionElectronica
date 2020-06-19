package Servlet.FacturaPDF;
 
import BaseDatos.Conexion;

import Entities.Comprobante;
import Entities.Emisor;
import Entities.Factura;
import Entities.Receptor;
import com.itextpdf.text.BaseColor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;

 
public class FacturaCFDI extends HttpServlet {
  private static Conexion con;
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            // Get the text that will be added to the PDF
            
            // step 1
            Document document = new Document(PageSize.A4);
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
           PdfWriter writer =  PdfWriter.getInstance(document, baos);
            
            
// step 3
            document.open();
            // step 4
            //Fuentes
            Font fuente1= new Font();
            fuente1.setSize(12);
            //Fuente 2
            Font fuente2 = new Font();
            fuente2.setSize(10);
            Font fuente3 = new Font();
            fuente3.setSize(9);
            
            //Hira la imagen de la empresa
            String ruta= "D:\\Gerardo\\Proyecto FactuFacil\\Factufacil\\src\\java\\Recursos\\factufacil.png";//Este parametro recibira el url de la imagen, 
            Image obj = Image.getInstance(ruta);//Crearemos un objeto de tipo imagen en donde se declara la instancia
            obj.setAbsolutePosition(40, 780);//se declaran x , y 
                        obj.scalePercent(50);
			document.add(obj);
            
            //Fecha y hora de la emisión
            Paragraph LFE = new Paragraph("\nLugar. fecha y hora de emisión: ", fuente3);
            LFE.setAlignment(Element.ALIGN_RIGHT);
           // document.add(LFE);
            //Fecha
             Calendar fecha = Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String CondicionFech=String.valueOf((año+"-"+mes+"-"+dia));
            //Hora
   Calendar calendario = Calendar.getInstance();
   int hora, minutos, segundos;
   hora =calendario.get(Calendar.HOUR_OF_DAY);
minutos = calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND);
            
        Paragraph a=new Paragraph( "\t\t\t" + LFE + "\n\t"+ "MÉXICO D.F. "+CondicionFech+ "T" + hora + ":" + minutos + ":\t" + segundos, fuente3);
					   a.setAlignment(Element.ALIGN_RIGHT);
                                          // a.setAlignment(Integer.compareUnsigned(600, 400));
					   document.add(a);
                       
            //Datos Emisor
                                  
String parametro = request.getParameter("btnCFDI");
String message= Emisor.EmisorDatos(parametro);


                  Paragraph Emisor = new Paragraph("\fDatos del emisor: "
                          + message, fuente3);
                  Emisor.setAlignment(Element.ALIGN_LEFT);
                  document.add(Emisor);
                                     
                  //
                  
                  String msd = Receptor.ReceptorDatos(parametro);
                  Factura NS = new Factura();
                  String msg = NS.getCadenaAlfanumAleatoria();
                  Paragraph Receptor = new Paragraph("Datos del receptor "
                    + msd , fuente3);
                  Receptor.setAlignment(Element.ALIGN_JUSTIFIED);
                  document.add(Receptor);
                  
                  //Folio Fiscal
                  
                  Paragraph NSC = new Paragraph( " \t Folio Fiscal: \n" + msg, fuente3);
                  NSC.setAlignment(Element.ALIGN_LEFT);
                  document.add(NSC);
                  
                  //No Certificado Digital
                  Factura ncd = new Factura();
                  int ms = ncd.NoSerieCertificado();
                  Paragraph mn = new Paragraph("No Cetificado Digital: \n" + ms +"\n", fuente3);
                  mn.setAlignment(Element.ALIGN_LEFT);
                  document.add(mn);
                  Paragraph espacio = new Paragraph(""
                          + "\n"
                          + "\n");
                   document.add(espacio);
                  //tabla
                 Font F1 = new Font(FontFamily.COURIER,16,Font.BOLDITALIC,BaseColor.RED);//fuente1
					   Font F2 = new Font(FontFamily.COURIER,12,Font.BOLDITALIC,BaseColor.BLUE);//fuente2
					   Font F3 = new Font(FontFamily.COURIER,12,Font.BOLDITALIC,BaseColor.BLACK);//fuente3
					   Font fuente5 = new Font(FontFamily.COURIER,10, Font.BOLDITALIC, BaseColor.BLACK);
                                           
					   float[] medidaCeldas = {1.5f, 1.5f,1.5f, 1.5f,2.0f, 1.0f};///Dimenciones de ancho de columnas
					   PdfPTable tabla=new PdfPTable(6);//se crea la instancia de la tabla
					   tabla.setWidths(medidaCeldas);//se le agregan medidas especificas
					   PdfPCell celda=new PdfPCell(new Phrase("Datos del comprobante \n ",F1));//primera Celda
					   celda.setColspan(6);//uns colspan para la primera celda
					   celda.setHorizontalAlignment(Element.ALIGN_CENTER);//se alinea al centro
					   tabla.addCell(celda);//se agrega a la tabla
					   //---se agrega la cabezera
                                           tabla.addCell(new Phrase("Concepto", F2));
					   tabla.addCell(new Phrase("Cantidad",F2));
					   tabla.addCell(new Phrase("Unidad de medida",F2));
					   tabla.addCell(new Phrase("Descripcion",F2));
					   tabla.addCell(new Phrase("Precio Unitario",F2));
					   tabla.addCell(new Phrase("Subtotal",F2));
                                                                                     					   //---termino de agregar cabezera
					   ResultSet data;
					   String consulta = "select * from comprobante natural join factura where folio_fiscal='"+parametro+"'";
    
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        data= con.readData(consulta);
         while(data.next()){
								//--Se agregan los datos consultados en el PDF
                                                                tabla.addCell(new Phrase(data.getString(2),F3));
						tabla.addCell(new Phrase(data.getString(6),F3));
				    			tabla.addCell(new Phrase(data.getString(5),F3));
				    			tabla.addCell(new Phrase(data.getString(4),F3));
				    			tabla.addCell(new Phrase(data.getString(3),F3));
				    			tabla.addCell(new Phrase(data.getString(8),F3));
                                                        PdfPCell celdaFinal = new PdfPCell();
                                           celdaFinal.setColspan(4);
                                           tabla.addCell(celdaFinal);
                                           tabla.addCell(new Phrase("Iva: " + data.getString(9),fuente5));
                                           tabla.addCell(new Phrase("Total: " + data.getString(10)));
                                           PdfPCell celdaF = new PdfPCell();
                                           celdaFinal.setColspan(4);
                                           tabla.addCell(celdaF);
                                           

				    			 
							}
         
    }else{
        
    }
    					
							
            
            document.add(tabla);
            
            //Espacio 2
            Paragraph esp2 = new Paragraph("\n"
                    + "\n");
            document.add(esp2);
            
                                           
                                           
                                           String sellosat="No tengo ni una idea de lo que estoy "
                                                   + "haciendoASSA";
                                           
            String codigo = Base64.encodeBytes(sellosat.getBytes());     
      
    
                                           Paragraph sellos=new Paragraph(" Sello del SAT "
                                                   + new String(codigo));
                                           sellos.setAlignment(Element.ALIGN_LEFT);
                                           document.add(sellos);
//Codigo 
                                           
  Font tamanio = new Font();
  Font Font = new Font();
  tamanio.setSize(10);
  tamanio.setFamily(FontFamily.HELVETICA.toString());
  Font.setStyle(Font.BOLD);
  Font.setSize(12);
 
Factura CO = new Factura();

                                           String cadenaOriginal = CO.CadenaOriginal();
                                           Paragraph cadenaO= new Paragraph("Cadena Original del complementode certificación digital del SAT \n", Font);
                                           cadenaO.add(new Paragraph(cadenaOriginal, tamanio));
                                            
                                           cadenaO.setAlignment(Element.ALIGN_JUSTIFIED);
                                           document.add(cadenaO);
                                           //codigo qr
         String orig = "original String before base64 encoding in Java";

        //encoding  byte array into base 64
            String encoded = Base64.encodeBytes(orig.getBytes());     
      
           ResultSet datos;
           String mensaje2 = null;
					   String consul = "select * from comprobante natural join factura where folio_fiscal='"+parametro+"'";
    
    con = Conexion.getInstance("factufacil", "root", "");
    if(con.open()){
        datos= con.readData(consul);
         while(datos.next()){
	                                
                                           
 mensaje2 ="Detalle de la factura\n"
        + "Datos del emisor:\n"
        + "'"+message+"'\n"
        + "Datos del receptor:\n"
        + "'"+msd+"'\n"
        + "Sello del Sat:\n"
        + "'"+codigo+"'\n"
        + "Sello digital del CFDI:\n"
        + "'"+encoded+"'\n"
        + "Detalles Producto:\n"
        + "Concepto: \n"
        + ""+datos.getString(2)+"\n"
         + "Cantidad: \n"
         + "'"+datos.getString(6)+"'"
         + "Descripción: \n"
         + "'"+datos.getString(4)+"'\n"
         + "Precio Unitario: \n"
         + "'"+datos.getString(3)+"'\n"
         + "Subtotal: \n"
         + "'"+datos.getString(8)+"'\n"
         + "Iva: \n"
         + "'"+datos.getString(9)+"'\n"
         + "Total: \n"
         + "'"+datos.getString(10)+"'\n";
         }
    }
         
    
Image img;//Creamos una variable de tipo imagen
			BarcodeQRCode qr = new BarcodeQRCode(mensaje2, 230, 235, null); //se ingresa la variable que contendra el codigo y sus dimensiones
			img = qr.getImage();//agregamos el valor de qr a img
                        img.setAbsolutePosition(05, 05);
                        img.scalePercent(80);
			document.add(img);
                        //
                        //nos generara el sello del emisor
        
    
                                           Paragraph sello=new Paragraph("Sello digital del CFDI"
                                                   + new String(encoded));
                                          
                                           sello.setAlignment(Element.ALIGN_JUSTIFIED);
                                     
                                           document.add(sello);
                        
                        document.close();
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
            
            
        }
        
        catch(DocumentException e) {
            throw new IOException(e.getMessage());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FacturaCFDI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 6067021675155015602L;
 
    
    
}
