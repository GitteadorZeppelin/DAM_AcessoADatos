
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author gyro
 */
public class LectorFichero {

    public static void leo() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException {
        //Variables
        String linea = "";
        File f = new File("./12Pole.txt");
        String[] lineaPartida = null;
        BufferedReader br = new BufferedReader(new FileReader(f));
        //lee hasta que la linea sea diferente de null
        while (linea != null) {
            //Guardamos en una variable
            linea = br.readLine();
            //Si no es nula, divido la linea en un array por partes
            if (linea != null) {
                lineaPartida = linea.split("::");
                //Creo la carrera y la añado al ArrayList
                Carrera c = GestorCarreras.creoCarrera(lineaPartida);
                GestorCarreras.anado(c);
            }
        }
    }
}
