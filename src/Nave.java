public class Nave {
    // Constantes de clase: no cambian y pertenecen a la clase, no a cada nave
    public static final int TOCADO = 1;
    public static final int HUNDIDO = 2;

    private String nombre;
    private String tipo;
    public static int vida;
    private boolean hundido;

    // Constructor (El __init__)
    public Nave(String nombre, String tipo, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.hundido = false;
    }

    public int recibirDisparo() {
        if (this.hundido) {
            return HUNDIDO;
        }

        this.vida--; // Mucho más elegante que -= 1

        if (this.vida <= 0) {
            this.hundido = true;
            System.out.println(this.nombre + " hundido");
            return HUNDIDO;
        } else {
            System.out.println(this.nombre + " tocado. Vida restante: " + this.vida);
            return TOCADO;
        }
    }

    // Un "getter" para saber si está hundido desde fuera
    public boolean isHundido() {
        return this.hundido;
    }
}
