
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
 *
 * @author Jorge Alloza
 */
public class main {

    public static int pasoASegundos(int horas, int minutos, int segundos) {
        int segTotales = 0;
        //calculo todos los segundos
        segTotales += segundos + (minutos * 60) + (horas * 3600);
        return segTotales;
    }

    public static int calcularCoste(int segTotales, double tarifa) {
        int centimos = 0;
        double aux = 0; 
        aux = segTotales * tarifa;
        centimos = (int) Math.round(aux);
        return centimos;
    }

    public static double convertirAEuros(int centimos) {
        double euros = 0;
        euros = centimos /100 + (centimos%100 * 0.01);
        return euros;
    }

    public static void main(String[] args) {
        //declaramos los ficheros
        File f1 = new File("./tiempos.txt");
        File f2 = new File("./tarifas.txt");
        //declaro el arraylist para guardar objetos de tipo tirmpo,
        //hace más facil la ejecución
        ArrayList<Tiempos> listaTiempos = new ArrayList();
        //variables para leer horas, min y segundos, puntos y salto de linea
        int horas, min, seg, horas2, min2, seg2, puntos, puntos2, salto;
        //variable para el contador
        int cont = 0;
        //variable para los segundos totales
        int secTotales = 0;
        //valor para el coste en centimos
        int centimos;
        //variable para guardar la cantidad de horas min y segundos en forma de String
        String horasStr = "";
        String minStr = "";
        String secStr = "";
        //variable para guardar los euros
        double euros = 0.00;
        
        try {
            //si no existen los ficheros se crean
            if (!f2.exists()) {
                f2.createNewFile();
            }
            //declaracion de los data stream
            DataOutputStream fOut = new DataOutputStream(new FileOutputStream(f2));
            DataInputStream fIn = new DataInputStream(new FileInputStream(f1));
            //bucle que lee hasta que se llega al final que son 300
            while (cont < 300) {
                cont++;
                //leo en formato h h2 : m m2 : s s2 \n
                //para poder manejar más facilmente los datos
                horas = fIn.read();
                horas2 = fIn.read();
                puntos = fIn.read();
                min = fIn.read();
                min2 = fIn.read();
                puntos2 = fIn.read();
                seg = fIn.read();
                seg2 = fIn.read();
                salto = fIn.read();
                //conncateno las dos partes de las horas
                horasStr = (char) horas + "" + (char) horas2;
                //concateno las dos partes de los minutos
                minStr = (char) min + "" + (char) min2;
                //concatenos las dos partes de los segundos
                secStr = (char) seg + "" + (char) seg2;
                //hago el parseo a enteros para crear el contructor
                horas = Integer.parseInt(horasStr);
                min = Integer.parseInt(minStr);
                seg = Integer.parseInt(secStr);
                Tiempos t = new Tiempos(horas, min, seg);
                //añado el objeto a un arraylist
                listaTiempos.add(t);
            }
            //cierro el fichero de lectura
            fIn.close();
            //bucle que por cada elemento del arraylist
            for (Tiempos t : listaTiempos) {
                //asigno los valores de cada tarifa a las variables
                horas = t .getHoras();
                min = t.getMinutos();
                seg = t.getSegundos();
                //llamo a las funciones                
                secTotales = pasoASegundos(horas, min, seg);
                centimos = calcularCoste(secTotales, Tarifa.getTarifa());
                System.out.print(centimos + " - >");
                euros = convertirAEuros(centimos);
                //escribo cada tarifa
                fOut.writeUTF(euros + "\n");
                //limpio el flush
                fOut.flush();              
            }
            //cierro el fichero de escritura
            fOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero " + f1.getName() + " no encontardo");
        } catch (IOException ex) {
            System.out.println("Error con el fichero " + ex.getMessage());
        }

    }
}
