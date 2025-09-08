package ar.edu.uni;

public class ReactorPWR extends Equipo implements Sensor, Controlable{

    //Encapsulamos para que sean invariantes y solo dentro de la clase

    private double nivelDePotencia;
    private boolean reactorEncendido;

    public ReactorPWR(String id, String nombreEquipo){
        //Pasamos los parámetros del constructor de la clase abstracta
        super(id, nombreEquipo);
        this.reactorEncendido = reactorEncendido;
        this.nivelDePotencia = 0.0;
    }

    @Override
    public void encender(){
        if(!estaEnServicio()) {
            System.out.println("[WARN] Reactor fuera de servicio, no puede encender.");
            return;
        }

        reactorEncendido = true;
        nivelDePotencia = 5.0;
        System.out.println("[ON] Reactor encendido. Potencia=" + nivelDePotencia + "%");

    }

    @Override
    public void apagar(){
        nivelDePotencia = 0.0;
        reactorEncendido = false;
        System.out.println("[OFF] Reactor apagado.");
    }

    @Override
    public void scram() {
        nivelDePotencia = 0.0;
        reactorEncendido = false;
        System.out.println("[SCRAM] Parada de emergencia ejecutada. Potencia=0%.");
    }

    @Override
    public boolean estaEncendido() {
        return reactorEncendido;
    }


    @Override
    public String descripcionTecnicaDeEquipo() {
        return "Reactor PWR (agua a presión) con barras de control y circuito primario.";
    }

    @Override
    public String getNombre() {
        return "REACTOR N° 1";
    }

    @Override
    public double leerValor() {
        return 280.0 + 0.4 * nivelDePotencia;
    }

    @Override
    public String estadoSensor() {
        return "Válido";
    }

    public double getNivelDePotencia(){
        return nivelDePotencia;
    }

    // Encapsulamiento: setter con regla de negocio (0..100 y cambios graduales)
    public void setNivelDePotencia(double nuevaPotencia) {
        if (nuevaPotencia < 0 || nuevaPotencia > 100) {
            throw new IllegalArgumentException("Potencia fuera de rango (0..100)");
        }
        if (!estaEncendido()) {
            System.out.println("[WARN] Reactor apagado: ignorando cambio de potencia.");
            return;
        }
        // (simplificado) limitamos rampas bruscas
        double delta = Math.abs(nuevaPotencia - this.nivelDePotencia);
        if (delta > 20) {
            System.out.println("[WARN] Cambio de potencia demasiado brusco (>20%). Ajustando gradualmente.");
            this.nivelDePotencia += Math.signum(nuevaPotencia - this.nivelDePotencia) * 20;
        } else {
            this.nivelDePotencia = nuevaPotencia;
        }
        System.out.println("[PWR] Potencia objetivo=" + this.nivelDePotencia + "%");
    }
}
