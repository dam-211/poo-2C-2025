package ar.edu.uni;

public class BombaAguaPrimaria extends Equipo implements Controlable, Sensor{

    private boolean encendida;
    private double caudalM3h; // caudal instantáneo simplificado

    protected BombaAguaPrimaria(String id, String nombreEquipo) {
        super(id, nombreEquipo);
        this.encendida = false;
        this.caudalM3h = 0.0;
    }

    @Override
    public void encender() {
        if (!estaEnServicio()) {
            System.out.println("[WARN] Bomba fuera de servicio, no puede encender.");
            return;
        }
        encendida = true;
        caudalM3h = 500.0; // valor de arranque nominal
        System.out.println("[ON] Bomba encendida. Caudal=" + caudalM3h + " m3/h");
    }

    @Override
    public void apagar() {
        encendida = false;
        caudalM3h = 0.0;
        System.out.println("[OFF] Bomba apagada.");
    }

    @Override
    public void scram() {
        apagar(); // en SCRAM, se apagan bombas si procede (simplificado)
        System.out.println("[SCRAM] Bomba detenida por seguridad.");
    }

    @Override
    public boolean estaEncendido() {
        return false;
    }

    @Override
    public String descripcionTecnicaDeEquipo() {
        return "Bomba centrífuga del circuito primario con control de caudal.";
    }

    @Override
    public String getNombre() {
        return "Bomba N° 1";
    }

    @Override
    public double leerValor() {
        return caudalM3h;
    }

    @Override
    public String estadoSensor() {
        return "Degradado en un 22%";
    }

    public void setCaudalM3h(double nuevoCaudal) {
        if (nuevoCaudal < 0) throw new IllegalArgumentException("Caudal negativo");
        if (!encendida) {
            System.out.println("[WARN] Bomba apagada: ignorando cambio de caudal.");
            return;
        }
        this.caudalM3h = nuevoCaudal;
        System.out.println("[FLOW] Caudal ajustado a " + caudalM3h + " m3/h");
    }
}
