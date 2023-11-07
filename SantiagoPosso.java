
import java.util.Scanner;
import java.io.*;

public class SantiagoPosso {
    private static void ordenarValores(String[][] data) {
        double horaMax = Double.MIN_VALUE;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != null) {
                    String[] parts = data[i][j].split(";");
                    if (parts.length >= 5) {
                        try {
                            double column2Value = Double.parseDouble(parts[4]);
                            if (column2Value > horaMax) {
                                horaMax = column2Value;
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        System.out.println("La hora es: " + horaMax);
    }

   
    public static void EncontrarValores(String[][] data, String id) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != null) {
                    String[] parts = data[i][j].split(";");
                    if (parts.length >= 5) {
                        try {
                            String column2Value = parts[0];
                            if (parts[0].equals(id)) {
                                System.out.println("Id: " + parts[0] + ", valor: " + parts[1] + ", tipo de emisor: " + parts[2] + ", tipo de receptor: " + parts[3] + ", Hora: " + parts[4]);}
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            } 
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dias = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
        String[][] data = new String[7][100];

        for (int i = 0; i < 7; i++) {
            System.out.println("Los dias son: " + dias[i]);
            String dia = dias[i];
            String fileName = "C:\\Users\\user\\OneDrive\\Escritorio\\Santiago Posso\\" + dia + ".txt";
            try {
                BufferedReader leer = new BufferedReader(new FileReader(fileName));
                String line;
                int a = 0;
                while ((line = leer.readLine()) != null) {
                    data[i][a] = line;
                    a++;
                    System.out.println(line);
                
                }
                leer.close();
            } catch (Exception e) {

                System.out.println("Error al leer el archivo del " + dia + ": " + e.getMessage());
            }

        } // fin del for
        while (true) {
            System.out.println(
                    "Bienvenido a billetera digital \n1. Día de la semana en que más se movió el dinero\n2. Hora del día en que más se movió el dinero\n3. Información por el ID de transaccion\n4. Ver los datos\n5. Cerrar");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    double maxValor = Double.MIN_VALUE;
                    String diaMaxValor = "";

                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            if (data[i][j] != null) {
                                String[] parts = data[i][j].split(";");
                                if (parts.length >= 2) {
                                    double valor = Double.parseDouble(parts[1]);
                                    if (valor > maxValor) {
                                        maxValor = valor;
                                        diaMaxValor = dias[i];
                                    }
                                }
                            }
                        }
                    }

                    if (!diaMaxValor.isEmpty()) {
                        System.out.println("El día con el mayor valor de transacción es " + diaMaxValor);
                        System.out.println("El valor máximo es: " + maxValor);
                    }
                    break;
                case 2:
                    ordenarValores(data);
                    break;
                case 3:
                    System.out.print("Ingrese su ID de transaccion: ");
                    String id = scanner.nextLine();
                    EncontrarValores(data, id);
                    break;
                case 4:
                    System.out.println("Datos disponibles:");
                    for (int i = 0; i < 7; i++) {
                        System.out.println(dias[i] + ": ");
                        for (int a = 0; a < data[i].length; a++) {
                            if (data[i][a] != null) {
                                System.out.println(data[i][a]);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cerrando.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, seleccione una opción válida.");
            }
        }

    }// fin main
}// fin class