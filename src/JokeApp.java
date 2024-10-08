import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class JokeApp {

    // Método para obtener un chiste aleatorio
    public static void obtenerChisteAleatorio() throws Exception {
        String urlString = "https://official-joke-api.appspot.com/random_joke";
        URI uri = new URI(urlString);
        URL url = uri.toURL(); // Conversión de URI a URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        // Mostrar el chiste en consola
        System.out.println("Chiste aleatorio:");
        System.out.println(content.toString() + "\n");
    }

    // Método para obtener 10 chistes aleatorios
    public static void obtenerDiezChistes() throws Exception {
        String urlString = "https://official-joke-api.appspot.com/random_ten";
        URI uri = new URI(urlString);
        URL url = uri.toURL(); // Conversión de URI a URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        // Mostrar los 10 chistes en consola
        System.out.println("10 chistes aleatorios:");
        System.out.println(content.toString() + "\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Menú interactivo
        while (continuar) {
            System.out.println("---- Plataforma de Aprendizaje ----");
            System.out.println("1. Ver un chiste aleatorio");
            System.out.println("2. Ver 10 chistes aleatorios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        obtenerChisteAleatorio();
                        break;
                    case 2:
                        obtenerDiezChistes();
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida, intenta nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

