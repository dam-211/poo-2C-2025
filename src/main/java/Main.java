public class Main {
    public static void main(String[] args) {
        // Creación de Pokémon
        Pokemon charizard = new Fuego("Charizard", 20, 200);
        Pokemon blastoise = new Agua("Blastoise", 18, 180);
        Pokemon venusaur = new Planta("Venusaur", 19, 190);

        System.out.println("--- Combate normal ---");
        // Polimorfismo en acción: el método atacar llama a la lógica correcta de cada subclase
        charizard.atacar(venusaur); // Fuego ataca a Planta (daño x1.5)
        blastoise.atacar(charizard); // Agua ataca a Fuego (daño x1.5)
        venusaur.atacar(blastoise); // Planta ataca a Agua (daño x1.5)

        System.out.println("\n--- Combate con sobrecarga y clima ---");
        // Sobrecarga de método: usamos la versión que incluye el clima
        blastoise.atacar(charizard, "lluvia"); // Daño de Blastoise potencia por lluvia (x1.2)
        charizard.atacar(venusaur, "soleado"); // Daño de Charizard potencia por sol (x1.2)
    }
}