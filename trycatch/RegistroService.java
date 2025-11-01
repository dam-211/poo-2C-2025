java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistroService {

    // Checked propia: obliga a quien llame a manejar o propagar
    public int parsearEdad(String texto) throws DatosInvalidosException {
        try {
            int edad = Integer.parseInt(texto);
            if (edad < 0 || edad > 120) {
                throw new DatosInvalidosException("Edad fuera de rango: " + edad);
            }
            return edad;
        } catch (NumberFormatException e) {
            // Wrappeo en checked → el compilador exige manejo
            throw new DatosInvalidosException("Edad no numérica: '" + texto + "'", e);
        }
    }

    // Otra checked del JDK (IOException): también obliga manejo
    public String leerPrimeraLinea(Path ruta) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            return br.readLine();
        }
    }
}
