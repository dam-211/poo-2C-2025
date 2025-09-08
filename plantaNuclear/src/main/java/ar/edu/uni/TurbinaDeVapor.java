package ar.edu.uni;

public class TurbinaDeVapor extends Equipo implements Controlable {

    private boolean encendida;
    private double rpm;

    protected TurbinaDeVapor(String id, String nombreEquipo) {
        super(id, nombreEquipo);
        this.encendida = false;
        this.rpm = 0.0;
    }

    @Override
    public void encender() {
        if (!estaEnServicio()) {
            System.out.println("[WARN] Turbina fuera de servicio, no puede encender.");
            return;
        }
        encendida = true;
        rpm = 1500.0; // nominal simplificado
        System.out.println("[ON] Turbina en giro. RPM=" + rpm);
    }

    @Override
    public void apagar() {
        encendida = false;
        rpm = 0.0;
        System.out.println("[OFF] Turbina detenida.");
    }

    @Override
    public void scram() {
        apagar();
        System.out.println("[SCRAM] Turbina desacoplada del generador.");
    }

    @Override
    public boolean estaEncendido() {
        return encendida;
    }

    @Override
    public String descripcionTecnicaDeEquipo() {
        return "Turbina de vapor acoplada a generador síncrono.";
    }
}
