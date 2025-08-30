# TP POO

## Objetivos

-   Modelar una **jerarquía** con una **clase abstracta** y **subclases
    concretas**.
-   Aplicar **polimorfismo** al calcular daño según el tipo del
    atacante.
-   Implementar **sobrecarga** de métodos (mismo nombre, firmas
    distintas).
-   Asegurar **validaciones básicas** y buen diseño (SRP/LSP).

## Enunciado (resumen)

Modelar un sistema mínimo de combate con tres tipos: **Fuego**, **Agua**
y **Planta**.\
Cada Pokémon tiene `nombre`, `nivel`, `hp` (salud) y un **tipo**. Deben
poder **atacar** a otro Pokémon. El daño base se ajusta por
**efectividad de tipos**:

-   Fuego \> Planta (x1.5)\
-   Agua \> Fuego (x1.5)\
-   Planta \> Agua (x1.5)\
-   Mismo tipo o no efectivo: x1.0

Además, incluir dos variantes de ataque (**sobrecarga**): 1.
`atacar(Pokemon objetivo)` (normal). 2.
`atacar(Pokemon objetivo, String clima)` donde: - `"soleado"` potencia
Fuego (x1.2) y debilita Agua (x0.8). - `"lluvia"` potencia Agua (x1.2) y
debilita Fuego (x0.8). - otros climas: neutro (x1.0).

> Bonus opcional: interfaz `Evolucionable` con
> `boolean puedeEvolucionar()`.

------------------------------------------------------------------------

## Código inicial (starter)

``` java
abstract class Pokemon {
    protected String nombre;
    protected int nivel;
    protected int hp;
    protected final Tipo tipo;

    public Pokemon(String nombre, int nivel, int hp, Tipo tipo) {
        // TODO: validar que nivel >= 1 y hp > 0
    }

    // Constructor sobrecargado (nivel=1, hp=50)
    public Pokemon(String nombre, Tipo tipo) { ... }

    public abstract void hacerSonido();
    protected abstract int poderBase();

    public void atacar(Pokemon objetivo) { ... }
    public void atacar(Pokemon objetivo, String clima) { ... }

    // Métodos auxiliares: calcularDaño, recibirDaño, etc.
}

class Fuego extends Pokemon { ... }
class Agua extends Pokemon { ... }
class Planta extends Pokemon { ... }

public class PokemonApp {
    public static void main(String[] args) {
        // TODO: crear lista de Pokémon y probar ataques
    }
}
```

-----------------------------------------------------------------------------

## Entregables

1.  Código Java en un único archivo `.java` (sin packages).\
2.  Prueba en `main` con al menos 3 Pokémon distintos.\
3.  Demostrar polimorfismo (misma llamada, distinto resultado).\
4.  Usar correctamente **sobrecarga** de métodos/constructores.\
5.  Validaciones simples y mensajes claros.

------------------------------------------------------------------------

## Criterios de evaluación

-   **Herencia y abstracción (30%)**\
-   **Polimorfismo en ataques (25%)**\
-   **Sobrecarga (20%)**\
-   **Calidad y validaciones (15%)**\
-   **Pruebas en main (10%)**
