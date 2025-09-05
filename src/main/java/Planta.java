public class Planta extends Pokemon {

    public Planta(String nombre, int nivel, double hp) {
        super(nombre, nivel, hp);
        this.tipo = "Planta";
    }

    @Override
    public double calcularDanio(Pokemon objetivo) {
        double danioBase = this.nivel * 10;
        double multiplicador = 1.0;

        if ("Agua".equals(objetivo.getTipo())) {
            multiplicador = 1.5; // Muy efectivo
        } else if ("Fuego".equals(objetivo.getTipo())) {
            multiplicador = 1.0; // No muy efectivo, se mantiene en 1.0
        }

        return danioBase * multiplicador;
    }
}
