package carrerakarts;

import java.util.Scanner;


public class CarreraKarts {

    static void verClasificacion(int[] p) {
        System.out.printf("CLASIF.: (%d", p[0]);
        for (int i = 1; i < p.length; i++) {
            System.out.print("," + p[i]);
        }
        System.out.println(")");
    }

    static int verPos(int[] p, int numero) {
        int i = 0;
        while (p[i] != numero) {
            i++;
        }
        return i;
    }

    static void reordenar(int[] p, int numero, int adelanta) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == numero) {
                int adelantado = p[i - adelanta];
                p[i - adelanta] = numero;
                p[i] = adelantado;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ------- DECLARACIONES E INICIALIZACIONES
        // Declarar arrays de objetos
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce nº total de karts: ");
        int n = s.nextInt();
        Kart[] kart = new Kart[n];
        // Declarar array de posiciones
        // El coche nº 10 lo poenmos en posición 1, el 9 en la 2, ...
        int[] posicion = new int[kart.length];
        // Variable que registra adelantamientos
        int adelantamiento = 0;
        // Instanciar objetos
        for (int i = 0; i < kart.length; i++) {
            posicion[i]=kart.length-i;
            kart[i] = new Kart(i + 1, 40 + i);
        }
        // Ver propiedades de los objetos
        for (int i = 0; i < kart.length; i++) {
            System.out.println(kart[i]);
        }
        // --------------------------
        // Ver clasificación actual
        verClasificacion(posicion);
        // Dar una vuelta para todos los kart       
        for (int v = 1; v <= 6; v++) {
            System.out.println("))))) VUELTA: " + v);
            for (int i = 0; i < kart.length; i++) {
                adelantamiento = kart[i].vuelta();
                if ((adelantamiento != 0)
                        && (verPos(posicion, kart[i].numero) - adelantamiento) >= 0) {
                    reordenar(posicion, kart[i].numero, adelantamiento);
                }
            }
            // Ver clasificación actual
            verClasificacion(posicion);
        }
        // Ver propiedades de los objetos
        for (int i = 0; i < kart.length; i++) {
            System.out.println(kart[i]);
        }

    }

}
