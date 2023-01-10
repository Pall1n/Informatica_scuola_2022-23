public class Main {
    public static void main(String[] args){
        Palazzo p1 = new Palazzo(3, 100, "Viale della Regione", 42, "Caltanissetta", 93100);
        p1.stampaInfo(3.4);
        Palazzo p2 = new Palazzo(4, 200, "Viale Trieste", 15, "Caltanissetta", 93100);
        p2.stampaInfo(2);
        Palazzo p3 = new Palazzo(5, 100, "Via San G. Bosco", 23, "Caltanissetta", 93100);
        p3.stampaInfo(1.5);
    }
}