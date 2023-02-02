public class Main {
    public static void main(String[] args) {
        Bicicletta bici = new Bicicletta(2, 20, "rosso");
        bici.accelera();
        Auto auto = new Auto(4, 200, "blu");
        auto.accelera();
    }
}