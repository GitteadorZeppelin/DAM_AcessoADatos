
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gyro
 */
public class CreadorXML {
    //Constantes
    final static private String RUTAFICHERO = "circuitos.xml";
    final static private String RAIZ = "carreras";

    //Función que crea el XML
    public static void construyoXML(ArrayList array) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //Creo los elementos necesarios para crear un documento
        DocumentBuilderFactory docBuildFac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuild = docBuildFac.newDocumentBuilder();
        Document doc = docBuild.newDocument();
        //Creo el elemento raiz
        Element raiz = doc.createElement(RAIZ);
        //Añado la raiz al documento
        doc.appendChild(raiz);
        //Llamo al metodo para crear el arbol xml
        creoArbol(array, doc, raiz);
        //Imprimo el arbol en el documento
        imprimoXML(doc);
    }
    //Metodo que crea el arbol xml
    public static void creoArbol(ArrayList array, Document doc, Element raiz) throws TransformerException {
        //Creo un iterador para recorrer el arraylist
        Iterator<Carrera> it = GestorCarreras.getListaCarreras().iterator();
        //Mientras haya objetos 
        while (it.hasNext()) {
            //Crea un objeto
            Carrera c = it.next();
            //Creo el elemento xml y le asigno el ID
            Element carrera = doc.createElement("carrera");
            Attr atributo = doc.createAttribute("id");
            atributo.setValue(c.getId());
            carrera.setAttributeNode(atributo);
            //Creo los nodos y los añado al padre (carrera)
            creoNodo(carrera, doc, "nombre", c.getNombre());
            creoNodo(carrera, doc, "escuderia", c.getEscuderia());
            creoNodo(carrera, doc, "modelo", c.getModelo());
            creoNodo(carrera, doc, "circuito", c.getCircuito());
            creoNodo(carrera, doc, "ano", c.getAno());
            creoNodo(carrera, doc, "velocidad", c.getVelocidad());
            //Añado el hijo al padre
            raiz.appendChild(carrera);
        }
        
    }
    //Metodo que crea el nodo y lo añade al padre (dato a carrera)
    public static void creoNodo(Element carrera, Document doc, String etiqueta, String dato) {
        Element hijo = doc.createElement(etiqueta);
        hijo.appendChild(doc.createTextNode(dato));
        carrera.appendChild(hijo);
    }
    //Metodo que imprime el xml con dormato
    public static void imprimoXML(Document doc) throws TransformerConfigurationException, TransformerException{
        //creo lso elementos para imprimir
        TransformerFactory transFac = TransformerFactory.newInstance();
        Transformer trans = transFac.newTransformer();
        //formato
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        //imprimo
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(RUTAFICHERO));
        trans.transform(source, result);
    }
}
