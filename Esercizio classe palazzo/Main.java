public class Main {
    public static void main(String[] args){
        final String RESET_COLOR = "\u001B[0m";
        System.out.println("\n");

        Palazzo p1 = new Palazzo(3, 100, "Viale della Regione", 42, "Caltanissetta", 93100);
        p1.setNumPiani(5);
        p1.setMq(180);
        p1.stampaInfo((float) 3.4);

        System.out.println("\n--------------------\n");

        Palazzo p2 = new Palazzo(4, 200, "Via Roma", 15, "Sesto San Giovanni", 20099);
        System.out.println("\u001B[33mIl valore del palazzo equivale a: \033[4;33m" + p1.calcValore((float) 3.1) + "\u001B[0;33m euro" + RESET_COLOR);
        p2.setNumPiani(7);
        p2.stampaInfo((float) 2);

        System.out.println("\n--------------------\n");

        Palazzo p3 = new Palazzo(5, 160, "Via S. Giovanni Bosco", 23, "Monza", 20900);
        p3.setMq(120);
        p3.stampaInfo((float) 1.5);

        System.out.println("\n");
    }
}