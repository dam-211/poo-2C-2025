@startuml
abstract class Pokemon {
# nombre: String
# nivel: int
# hp: double
# tipo: String

    + Pokemon(nombre: String, nivel: int, hp: double)
    + {abstract} calcularDanio(objetivo: Pokemon): double
    + atacar(objetivo: Pokemon): void
    + atacar(objetivo: Pokemon, clima: String): void
    + recibirDanio(danio: double): void
    + getNombre(): String
    + getHp(): double
    + getTipo(): String
}

class Fuego {
+ Fuego(nombre: String, nivel: int, hp: double)
+ calcularDanio(objetivo: Pokemon): double
}

class Agua {
+ Agua(nombre: String, nivel: int, hp: double)
+ calcularDanio(objetivo: Pokemon): double
}

class Planta {
+ Planta(nombre: String, nivel: int, hp: double)
+ calcularDanio(objetivo: Pokemon): double
}

class Main {
+ {static} main(args: String[]): void
}

Pokemon <|-- Fuego
Pokemon <|-- Agua
Pokemon <|-- Planta

Main ..> Pokemon : usa
Main ..> Fuego : crea
Main ..> Agua : crea
Main ..> Planta : crea

Pokemon "1" -- "1" Pokemon : ataca a

@enduml

Esta clase es la base de nuestra jerarquía. 
Contiene los atributos y el comportamiento común a todos los Pokémon, como su nombre, nivel, puntos de salud (hp) y tipo. 
La hacemos abstracta porque no tiene sentido crear un objeto de tipo Pokemon genérico; siempre debe ser de un tipo concreto, como Fuego, Agua o Planta.

La clase tiene un método abstracto calcularDanio(Pokemon objetivo) que cada subclase debe implementar a su manera, aplicando las reglas de efectividad.

Estas clases heredan de Pokemon y son las que podemos instanciar (crear objetos). Cada una implementa el método calcularDanio() de forma distinta, aplicando
la lógica de polimorfismo según las reglas de efectividad de tipos.

Jerarquía de clases: La clase Pokemon es la base de la que heredan Fuego, Agua y Planta, organizando la estructura del programa.

Clase abstracta: Pokemon es abstracta para forzar a las subclases a implementar su propia lógica de daño. No podemos crear un objeto new Pokemon().

Polimorfismo: Cuando llamamos a pokemon.atacar(otroPokemon), el compilador y la JVM saben que la implementación de calcularDanio() a usar es la de la clase concreta del objeto (Fuego, Agua o Planta), no la de la clase abstracta. Esto permite que un mismo método tenga comportamientos distintos según el objeto que lo invoca.

Sobrecarga de métodos: Tenemos dos métodos atacar() en la clase Pokemon. Ambos tienen el mismo nombre, pero sus firmas son diferentes (atacar(Pokemon objetivo) vs. atacar(Pokemon objetivo, String clima)), lo que nos permite elegir cómo queremos que ocurra el ataque.
