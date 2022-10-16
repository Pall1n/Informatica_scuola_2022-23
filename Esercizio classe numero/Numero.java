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

import java.lang.Math;

public class Numero {
    private int numero;

    public Numero (int n) {
        this.numero = n;
    }

    public int quadrato() {
        return numero*numero;
    }

    public double radice() {
        return Math.sqrt(numero);
    }

    public int fattoriale() {
        int fact = 1;
        for(int i = 1; i <= numero; i++) {
            fact*=i;
        }
        return fact;
    }

    public void negazione() {
        this.numero *= -1;
    }

    public String binario() {
        return Integer.toBinaryString(numero);
    }

    public String esadecimale() {
        return Integer.toHexString(numero);
    }

    public void incrementa() {
        this.numero += 1;
    }

    public void decrementa() {
        this.numero -= 1;
    }

    public double calcolo() {
        return Math.pow(numero, 2) + numero + 1;
    }
}