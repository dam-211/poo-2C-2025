package ar.edu.uni;

public class SensorRadiacion implements Sensor {

    private final String nombre;

    public SensorRadiacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double leerValor() {
        // uSv/h – valor ficticio estable
        return 0.12;
    }

    @Override
    public String estadoSensor() {
        return "Al 96% -- Operación de emergencia - Checksum SHA-256 de Firmware no válido!";
    }
}
