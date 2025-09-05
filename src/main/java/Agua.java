public class Agua extends Pokemon {

    public Agua(String nombre, int nivel, double hp) {
        super(nombre, nivel, hp);
        this.tipo = "Agua";
    }

    @Override
    public double calcularDanio(Pokemon objetivo) {
        double danioBase = this.nivel * 10;
        double multiplicador = 1.0;

        if ("Fuego".equals(objetivo.getTipo())) {
            multiplicador = 1.5; // Muy efectivo
        } else if ("Planta".equals(objetivo.getTipo())) {
            multiplicador = 1.0; // No muy efectivo, se mantiene en 1.0
        }

        return danioBase * multiplicador;
    }
}