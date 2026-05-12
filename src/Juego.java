import java.util.Scanner;

public class Juego {
    private Tablero tablero;

    public Juego() {
        // Inicializamos o taboleiro (que xa ten as súas naves e vidas totais)
        this.tablero = new Tablero();
        Scanner teclado = new Scanner(System.in);

        /** * O bucle agora consulta ao OBXECTO tablero.
         * Mentres o taboleiro diga que quedan vidas na flota, o xogo segue.
         **/
        while (this.tablero.getVidasTotais() > 0) {
            System.out.println("\n--- NUEVO TURNO ---");
            System.out.println("Vidas restantes na flota: " + this.tablero.getVidasTotais());

            try {
                System.out.print("Introduce fila (x): ");
                int x = Integer.parseInt(teclado.nextLine());
                System.out.print("Introduce columna (y): ");
                int y = Integer.parseInt(teclado.nextLine());

                // Chamamos a lanzarAtaque e imprimimos o que pasa
                String resultado = lanzarAtaque(x, y);
                System.out.println("RESULTADO: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Erro: Debes introducir un número enteiro.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro: Coordenadas fóra do taboleiro (usa 0-9).");
            }
        }

        // Cando sae do bucle é porque vidasTotais == 0
        mostrarVictoria();
    }

    public String lanzarAtaque(int x, int y) {
        System.out.println("Atacando a [" + x + "," + y + "]....");

        // 1. Pedimos á casilla correspondente que reciba o disparo
        // Usamos o getter do tablero para chegar á casilla
        int resultado = this.tablero.getCasillero()[x][y].recibirDisparo(x,y);

        String textoResultado = "";

        // 2. Lóxica de resposta baseada no que devolve recibirDisparo()
        if (resultado == 0) { // AGUA
            textoResultado = "Agua";
        } else {
            // Se o resultado é 1 (Tocado) ou 2 (Afundido), restamos unha vida á flota
            this.tablero.reducirVidaGlobal();

            if (resultado == 1) {
                textoResultado = "¡TOCADO!";
            } else {
                textoResultado = "¡HUNDIDO!";
            }
        }

        return textoResultado;
    }

    public void mostrarVictoria() {
        System.out.println("\n================================================");
        System.out.println("          ¡MISIÓN CUMPLIDA, CAPITÁN!          ");
        System.out.println("================================================");
        System.out.println("             *¡V I C T O R I A!* ");
    }

}