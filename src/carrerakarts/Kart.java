package carrerakarts;


public class Kart {

    // Atributos
    int numero;
    int deposito; // Medido en decilitros
    int velocidad;

    // Constructor
    Kart(int numero, int velocidad) {
        this.numero = numero;
        this.deposito = 30;
        this.velocidad = velocidad;
    }
    // getter

    public int getDeposito() {
        return this.deposito;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    // Otros métodos
    int vuelta() {
        System.out.println("...Inicio de vuelta del coche "+this.numero);
        int adelanta = 0;
        this.deposito -= (int) (3 + Math.random() * 4);  // Gasta de 3 a 6 dl
        int suerte = (int) (Math.random() * 10);
        switch (suerte) {
            case 0:
            case 1:
                adelanta++;
                System.out.printf("--- El coche %d tiene un premio para adelantar.\n",this.numero);
                break;
            // El resto de psoibilidades se corresponden a no adelantar
        }
        return adelanta;
    }

    boolean depositoVacio() {
        boolean vacio = false;
        if (this.deposito != 0) {
            vacio = true;
        }
        return vacio;
    }
    
    public String toString () {
        String cadena=String.format("** Coche nº %d ** Dep. %d ** Vel. %d",
                this.numero,this.deposito,this.velocidad);
        return cadena;
    }
}
