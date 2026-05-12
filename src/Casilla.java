public class Casilla {
    private Nave nave;
    private boolean disparada;
    private String tipo;


    public Casilla(String tipo) {
        this.tipo = tipo;
        this.nave = null; // Non hai nave nesta casilla
    }

    // 2. CONSTRUCTOR PARA NAVES (Recibe un obxecto Nave)
    public Casilla(Nave nave) {
        this.tipo = "ocupada"; // Ou o que ti queiras poñer
        this.nave = nave;
    }

    public int recibirDisparo(int x, int y) {
        if (this.disparada) {
            if (this.nave == null) {
                return 0;
            }
            return this.nave.isHundido() ? 2 : 1;
        }


        this.disparada = true;
        if (this.nave == null) {
            return 0;
        } else {
            return this.nave.recibirDisparo();
        }
    }
}