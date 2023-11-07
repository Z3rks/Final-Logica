import java.util.Scanner;
import java.io.*;

public class SantiagoPosso {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dias = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
        String[][] data = new String[7][100];

        for (int i = 0; i < 7; i++) {
            System.out.println("El dia es: " + dias[i]);
            String dia = dias[i];
            String fileName = "C:\\Users\\user\\OneDrive\\Escritorio\\Santiago Posso\\" + dia + ".txt";
            try {
                BufferedReader leer = new BufferedReader(new FileReader(fileName));
                String line;
                int a = 0;
                while ((line = leer.readLine()) != null) {
                    data[i][a] = line;
                    a++;
                }
                leer.close();
            } catch (Exception e) {

                System.out.println("Error al leer el archivo del " + dia + ": " + e.getMessage());
            }

        } // fin del for

    }// fin main
}// fin class