
import java.util.Scanner;

public class Juego {
    private Tablero tablero;

    public Juego() {
        this.tablero = new Tablero();
        Scanner teclado = new Scanner(System.in);
        /** El objetivo es que vayas lanzando ataques hasta que no haya naves con vida, para eso hizo este menu/bucle, idee esta idea en prog
         * pero tuve que modificar un poco la clase nave para que vida funcione en este bucle**/
        while (Nave.vida > 0) {
            System.out.println("\n--- NUEVO TURNO ---");
            System.out.print("Introduce fila (x): ");
            int x = Integer.parseInt(teclado.nextLine());
            System.out.print("Introduce columna (y): ");
            int y = Integer.parseInt(teclado.nextLine());
            String resultado = lanzarAtaque(x, y);
            System.out.println(resultado);
            System.out.println("Vidas restantes: " + Nave.vida);
        }
        mostrarVictoria();
    }

    /**Se lo pedi a Gemini porque me parecia muy soso.Es muy sencillo, varios sout/print y lo llamo en el innit**/
    public void mostrarVictoria() {
        System.out.println("\n================================================");
        System.out.println("          ¡MISIÓN CUMPLIDA, CAPITÁN!          ");
        System.out.println("================================================");
        System.out.println("             *¡V I C T O R I A!*      ");
        System.out.println("    Has hundido toda la flota enemiga con éxito.");
        System.out.println("================================================");
    }
    /**Lanzar ataque la fusiobe con mostrar-resultado para optimizar y porque no me tiene mucho sentido crear una funcion
     * para un par de print asi que hice una fusion**/
    public String lanzarAtaque(int x, int y) {
        System.out.println("Atacando a " + x + ", " + y + "....");
        int resultado = tablero.recibir_disparo(x, y);
        String a = "";
        if (resultado == 0) {
            a = "Agua";
        } else {
            a = "Hundido";
        }
        return a;
    }

    public static void main(String[] args) {
        Juego j = new Juego();
        System.out.println(j);
    }
}