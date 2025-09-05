public abstract class Pokemon {
    protected String nombre;
    protected int nivel;
    protected double hp;
    protected String tipo;

    public Pokemon(String nombre, int nivel, double hp) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.hp = hp;
    }

    // Método polimórfico y abstracto para ser usado en las clases workers que sean necesarias
    public abstract double calcularDanio(Pokemon objetivo);

    // Sobrecarga 1: Atacar sin considerar el clima
    public void atacar(Pokemon objetivo) {
        double danio = this.calcularDanio(objetivo);
        objetivo.recibirDanio(danio);
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + ". ¡Hace " + danio + " de daño!");
    }

    // Sobrecarga 2: Atacar considerando el clima
    public void atacar(Pokemon objetivo, String clima) {
        double danio = this.calcularDanio(objetivo);

        // Ajuste de daño por clima
        if (clima != null) {
            clima = clima.toLowerCase();
            if ("soleado".equals(clima) && "Fuego".equals(this.tipo)) {
                danio *= 1.2;
            } else if ("soleado".equals(clima) && "Agua".equals(this.tipo)) {
                danio *= 0.8;
            } else if ("lluvia".equals(clima) && "Agua".equals(this.tipo)) {
                danio *= 1.2;
            } else if ("lluvia".equals(clima) && "Fuego".equals(this.tipo)) {
                danio *= 0.8;
            }
        }

        objetivo.recibirDanio(danio);
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " bajo el clima " + clima + ". ¡Hace " + danio + " de daño!");
    }

    public void recibirDanio(double danio) {
        this.hp -= danio;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.nombre + " recibe " + danio + " de daño. Le quedan " + this.hp + " HP.");
    }

    // Métodos utilitarios, geters y setters en la Abstracta.
    public String getNombre() {
        return nombre;
    }

    public double getHp() {
        return hp;
    }

    public String getTipo() {
        return tipo;
    }
}