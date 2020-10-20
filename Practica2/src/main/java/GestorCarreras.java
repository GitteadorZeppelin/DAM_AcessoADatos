import java.util.ArrayList;

/**
 *
 * @author gyro
 */
public class GestorCarreras {
    //ArrayList donde guarda las carreras con sus datos
    private static ArrayList<Carrera> listaCarreras = new ArrayList<>();
    
    //metodo que añade una carrera al ArrayList
    public static void anado(Carrera c){
       listaCarreras.add(c);
    }
    //Metodo que crea una carrera pasandole los datos en un array, y devuelve la
    //carrera
    public static Carrera creoCarrera(String[] datos){
        Carrera c = new Carrera(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
        return c;
    }
    // Getter y setter
    public static ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public static void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        GestorCarreras.listaCarreras = listaCarreras;
    }
    
    
}
