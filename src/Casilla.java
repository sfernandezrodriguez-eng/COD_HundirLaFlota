public class Casilla {
    private Nave nave;         // Si es null, es agua
    private boolean disparada; // Por defecto es false, Java no es vago

    // Constructor (El __init__)
    public Casilla(Nave nave) {
        this.nave = nave;
        this.disparada = false;
    }

    public int recibirDisparo() {
        // 1. Si ya fue disparada, gestionamos el estado actual
        if (this.disparada) {
            if (this.nave == null) {
                return 0; // Agua
            }
            return this.nave.isHundido() ? 2 : 1;
        }

        // 2. Primera vez que se dispara
        this.disparada = true;
        if (this.nave == null) {
            return 0; // Agua
        } else {
            // Llamamos al método de la clase Nave
            return this.nave.recibirDisparo();
        }
    }
}