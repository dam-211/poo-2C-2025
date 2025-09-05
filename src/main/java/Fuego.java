public class Fuego extends Pokemon {

    public Fuego(String nombre, int nivel, double hp) {
        super(nombre, nivel, hp);
        this.tipo = "Fuego";
    }

    @Override
    public double calcularDanio(Pokemon objetivo) {
        double danioBase = this.nivel * 10;
        double multiplicador = 1.0;

        if ("Planta".equals(objetivo.getTipo())) {
            multiplicador = 1.5; // Muy efectivo
        } else if ("Agua".equals(objetivo.getTipo())) {
            multiplicador = 1.0; // No muy efectivo, se mantiene en 1.0
        }

        return danioBase * multiplicador;
    }
}