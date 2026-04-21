public class Tablero {
    private final int DIM = 7;
    private Nave[][] matrizNaves;      // Guarda el objeto nave en la posición
    private boolean[][] matrizDisparos; // Guarda si ya se disparó ahí

    /**Hoy en clase dimos arrays asi que apartir de eso y de ayuda de gemini hice esta clase, creo que es la clase
     * más complicada de todo el proyecto pero basicamente con DIM ponemos el tope del tablero, si DIM es 5 entonces
     * el tablero es un 5x5, la matriz de nave y la matriz de disparo son para saber donde estan las naves y donde
     * se disparo con anterioridad**/
    public Tablero() {
        this.matrizNaves = new Nave[DIM][DIM];
        this.matrizDisparos = new boolean[DIM][DIM];
        this.colocarNavesEjemplo();
    }

    private void colocarNavesEjemplo() {
        // Creamos una nave de 2 de vida y la ponemos en dos posiciones
        Nave n1 = new Nave("damian","algo",2);
        matrizNaves[1][1] = n1;
        matrizNaves[1][2] = n1;
    }

    public int recibir_disparo(int x, int y) {
        // 1. Si ya fue disparada, gestionamos el estado actual
        if (matrizDisparos[x][y]) {
            if (matrizNaves[x][y] == null) {
                return 0; // Agua
            }
            // Retorna 3 (Hundido) o 2 (Tocado) según la nave
            return matrizNaves[x][y].isHundido() ? 3 : 2;
        }

        // 2. Primera vez que se dispara
        matrizDisparos[x][y] = true;

        if (matrizNaves[x][y] == null) {
            return 0; // Agua
        } else {
            // Llamamos al método de la clase Nave que resta vida
            return matrizNaves[x][y].recibirDisparo();
        }
    }
}

