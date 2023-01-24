public class Main {
    public static void main(String[] args) {
        Quadrato quadrato_brutto = new Quadrato("quadrato brutto", 5);
        quadrato_brutto.stampa();
        System.out.println();
        Triangolo triangolo_equilatero = new Triangolo("triangolo equilatero", "equilatero", 4, 3.464);
        triangolo_equilatero.stampa();
        System.out.println();
        Quadrato quadrato_bello = new Quadrato("quadrato bello", 4);
        quadrato_bello.stampa();
    }
}