public class Tablero {
    // 1. Constantes (static final para que non cambien e sexan da clase)
    public static final int AGUA = 0;
    public static final int TOCADO = 1;
    public static final int HUNDIDO = 2;

    // 2. Atributos privados (Encapsulamento)
    private Casilla[][] casillero;
    private int vidasTotais;

    public Tablero() {
        // Creamos as naves
        Nave por1 = new Nave("Damian", "portaaviones", 5);
        Nave fra1 = new Nave("Commit", "fragata", 3);
        Nave fra2 = new Nave("Push", "fragata", 3);
        Nave fra3 = new Nave("Un10plis", "fragata", 3);
        Nave sub1 = new Nave("U-47", "submarino", 1);
        Nave sub2 = new Nave("U-96", "submarino", 1);
        Nave sub3 = new Nave("U-505", "submarino", 1);
        Nave sub4 = new Nave("U-534", "submarino", 1);

        // Calculamos a suma de todas as vidas para saber cando acaba o xogo
        this.vidasTotais = por1.vida + fra1.vida + fra2.vida +
                fra3.vida + sub1.vida + sub2.vida +
                sub3.vida + sub4.vida;

        // 3. Inicializamos o casilleiro
        this.casillero = new Casilla[][] {
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla(por1), new Casilla(por1), new Casilla(por1), new Casilla(por1), new Casilla(por1), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla(fra1), new Casilla(fra1), new Casilla(fra1), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla(sub1), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla(fra2), new Casilla(fra2), new Casilla(fra2), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla(fra3), new Casilla(fra3), new Casilla(fra3), new Casilla("agua"), new Casilla("agua"), new Casilla(sub3), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua")},
                {new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla(sub4), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla("agua"), new Casilla(sub2)}
        };
    }

    // --- MÉTODOS GETTER ---

    public Casilla[][] getCasillero() {
        return this.casillero;
    }

    public int getVidasTotais() {
        return this.vidasTotais;
    }

    // Método para restar vida global cando hai un impacto
    public void reducirVidaGlobal() {
        this.vidasTotais--;
    }
}