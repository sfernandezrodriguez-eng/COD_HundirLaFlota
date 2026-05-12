/*Clase de la casilla, para dividir el tablero*/
public class Casilla {
    private Nave nave;
    private boolean disparada;
    private String tipo;

/*En esta clase se hace el "ataque" por asi decirlo, genera el ataque y comprueba si hay una nave o no*/
    public Casilla(String tipo) {
        this.tipo = tipo;
        this.nave = null; // Non hai nave nesta casilla
    }

    // 2. CONSTRUCTOR PARA NAVES (Recibe un obxecto Nave)
    public Casilla(Nave nave) {
        this.tipo = "ocupada";
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