package ar.edu.uni;

import java.util.ArrayList;
import java.util.List;

public class Orquestador {

    private final List<Controlable> sistemasControlables = new ArrayList<>();
    private final List<Sensor> sensores = new ArrayList<>();

    public void registrarControlable(Controlable c) {
        sistemasControlables.add(c);
    }

    public void registrarSensor(Sensor s) {
        sensores.add(s);
    }

    // Polimorfismo: misma llamada, distinta implementación concreta
    public void encenderTodo() {
        sistemasControlables.forEach(Controlable::encender);
    }

    public void scram() {
        System.out.println("\n=== SCRAM GLOBAL ===");
        sistemasControlables.forEach(Controlable::scram);
    }

    public void mostrarLecturas() {
        System.out.println("\n=== LECTURAS SENSORES ===");
        for (Sensor s : sensores) {
            System.out.printf("%s = %.3f%n", s.getNombre(), s.leerValor());
        }
    }

    public void mostrarEstadoSensores() {
        System.out.println("\n=== ESTADO SENSORES ===");
        for (Sensor s : sensores) {
            System.out.println("Sensor:" + s.getNombre() + s.estadoSensor() );
        }
    }
}
