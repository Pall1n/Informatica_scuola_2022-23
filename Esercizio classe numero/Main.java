/*
    Implementare la classe Numero che memorizzi un numero intero. La classe dovrà avere i seguenti metodi:
    - quadrato, che restituisca il quadrato del numero;
    - radice, che ne restituisca la radice;
    - fattoriale, che ne restituisca il fattoriale, esempio: !5 = 5*4*3*2*1
    - negazione, che inverta il segno di Numero
    - binario ed esadecimale, che restituisca rispettivamente il corrispondente in binario ed esadecimale.
    - Incrementa (di uno)
    - Decrementa (di uno)
    - Metodo che ritorna il calcolo della seguente formula x^2 + x + 1
*/

public class Main {
    public static void main(String[] args) {
        Numero numero = new Numero(1);
        System.out.println("Quadrato: " + numero.quadrato());
        System.out.println("Radice: " + numero.radice());
        System.out.println("Fattoriale: " + numero.fattoriale());
        System.out.println("Binario: " + numero.binario());
        System.out.println("Esadecimale: " + numero.esadecimale());
        numero.negazione();
        numero.incrementa();
        numero.decrementa();
        System.out.println("Calcolo: " + numero.calcolo());
    }
}