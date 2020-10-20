
import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author gyro
 */
public class Main {

    public static void main(String[] args) {
        try{
            //Leo fichero
            LectorFichero.leo();
            //Creo XML
            CreadorXML.construyoXML(GestorCarreras.getListaCarreras());
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParserConfigurationException ex){
            System.out.println("Error parseando");
        } catch (SAXException ex) {
            System.out.println("Error con el sax");
            System.out.println(ex);
        } catch (TransformerException ex) {
            System.out.println("Fallo al transformar");
        }
    }
}
