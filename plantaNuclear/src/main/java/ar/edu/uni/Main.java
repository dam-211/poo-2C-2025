package ar.edu.uni;


public class Main {
    public static void main(String[] args) {

        System.out.println("Springfield Nuclear Power Plant");

        ReactorPWR reactor = new ReactorPWR("R-01", "Reactor Primario");
        BombaAguaPrimaria bomba = new BombaAguaPrimaria("B-11", "Bomba Primario #1");
        TurbinaDeVapor turbina = new TurbinaDeVapor("T-21", "Turbina #1");
        SensorRadiacion rad = new SensorRadiacion("Rad-Monitor Sala Control");

        Orquestador planta = new Orquestador();
        planta.registrarControlable(reactor);
        planta.registrarControlable(bomba);
        planta.registrarControlable(turbina);

        // Un mismo objeto puede estar en varias colecciones por sus "roles" (interfaces)
        planta.registrarSensor(reactor); // el reactor actúa también como sensor (temperatura)
        planta.registrarSensor(bomba);   // la bomba reporta su caudal
        planta.registrarSensor(rad);     // sensor dedicado de radiación

        // Autodiagnósticos (herencia: algunos sobrescriben comportamiento)
        reactor.autodiagnosticoInicial();
        bomba.autodiagnosticoInicial();
        turbina.autodiagnosticoInicial();

        // Encendido coordinado (polimorfismo con Controlable)
        planta.encenderTodo();

        // Ajustes con reglas de negocio (encapsulamiento)
        reactor.setNivelDePotencia(35);
        reactor.setNivelDePotencia(80);   // advierte rampa brusca y limita a +20
        bomba.setCaudalM3h(650);

        // Lecturas polimórficas (Sensor)
        planta.mostrarLecturas();
        planta.mostrarEstadoSensores();

        // Evento: SCRAM
        planta.scram();
        planta.mostrarLecturas();
    }
}