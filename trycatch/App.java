
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        RegistroService service = new RegistroService();
        // Caso "A" Manejar en el mismo lugar con try/catch
        try {
            int edad = service.parsearEdad("25");
            System.out.println("Edad OK: " + edad);
        } catch (DatosInvalidosException e) {
            System.err.println("Error al parsear edad: " + e.getMessage());
        }
        // Caso "B" Llamar a un método que PROPAGA la excepción -->  main debe capturar
        try {

            crearUsuario("kdnkdsan", service);      // "abc" dispara DatosInvalidosException

        } catch (DatosInvalidosException e) {
            System.err.println("No se pudo crear usuario: " + e.getMessage());
        }
        // "C" Otra checked (IOException) obligando try/catch
        try {
            String linea = service.leerPrimeraLinea(Paths.get("archivo.txt"));
            System.out.println("Primera línea: " + linea);
        } catch (java.io.IOException e) {
            System.err.println("Problema de E/S: " + e.getMessage());
        }
    }
    // No maneja: DECLARA throws → obliga al llamador a try/catch o a seguir propagando
    static void crearUsuario(String edadComoTexto, RegistroService service)
            throws DatosInvalidosException {
        int edad = service.parsearEdad(edadComoTexto);
        System.out.println("Creado usuario con edad " + edad);
    }
}
