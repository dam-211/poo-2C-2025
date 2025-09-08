package ar.edu.uni;

//Creamos una clase abstracta llamada "Equipo", la cual permitirá la herencia a las clases workers.
//Esta clase no es posible instanciarla, solo nos permite organizar la herencia

//abstract --> obliga a implementar
//final en métodos: Son invariantes, prohibe la sobreescritura
//final en clases: prohibe heredad
//final en atributos: solo se asignan una vez.


abstract class Equipo {

    //Encapsulamos los atributos para no permitir acceso desde otras clases.
    //Solamente lo permitimos mediante getter y setters

    private final String id;
    private String nombreEquipo;
    private boolean equipoEnServicio;

    protected Equipo(String id, String nombreEquipo){
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.equipoEnServicio = equipoEnServicio;

    }

    //Las clases "final" no pueden ser heredadas
    //Cuando no queremos que las extiendan
    //El método no puede ser sobreescrito, es decir, poner el equipo en servicio o no
    //Son comportamientos invariantes que, en el caso de la central nuclear, convienen dejar fijos una unica vez.

    public final void ponerEquipoEnServicio(){
        this.equipoEnServicio = true;
    }

    public final void ponerEquipoEnMantenimiento(){
        this.equipoEnServicio = false;
    }

    public final void setNombreEquipo(String nombreEquipo){

        if(nombreEquipo == null || nombreEquipo.isBlank()){
            throw new IllegalArgumentException("El nombre no es válido");
        }
        this.nombreEquipo = nombreEquipo;
    }

    public void autodiagnosticoInicial(){
        System.out.println("[CHK-->] " + nombreEquipo + "(" + id + "): Inciando autodiangóstico general.");
        System.out.println("[CHK-->] " + nombreEquipo + "(" + id + "): Pasando a particular...");
    }

    //En este caso, al ser abstract, debo implementarlo en la clase hija
    public abstract String descripcionTecnicaDeEquipo();

    public final String getId(){
        return this.id;
    }

    public final String getNombreEquipo() {
        return this.nombreEquipo;
    }

    public final boolean estaEnServicio(){
        return equipoEnServicio;
    }
}
