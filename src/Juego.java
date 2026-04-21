
import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    public Nave nave;

    public Juego() {
        this.tablero = new Tablero();
        Scanner teclado = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (Nave.vida > 0) {
            System.out.println("\n--- NUEVO TURNO ---");
            System.out.print("Introduce fila (x): ");
            x = Integer.parseInt(teclado.nextLine());
            System.out.print("Introduce columna (y): ");
            y = Integer.parseInt(teclado.nextLine());
            String resultado = lanzarAtaque(x, y);
            System.out.println(resultado);
            System.out.println("Vidas restantes: " + Nave.vida);
        }
        mostrarVictoria();
    }


    public void mostrarVictoria() {
        System.out.println("\n================================================");
        System.out.println("          ¡MISIÓN CUMPLIDA, CAPITÁN!          ");
        System.out.println("================================================");
        System.out.println("             *¡V I C T O R I A!*      ");
        System.out.println("    Has hundido toda la flota enemiga con éxito.");
        System.out.println("================================================");
    }

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