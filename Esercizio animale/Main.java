public class Main {
    public static void main(String[] args) throws Exception {
        Cane argo = new Cane("Argo");
        argo.abbaia();
        argo.stampa();
        System.out.println();

        Gatto nino = new Gatto("Nino");
        nino.miagola();
        nino.stampa();
        System.out.println();

        Uccello franco = new Uccello("Franco");
        franco.cinguetta();
        franco.stampa();
    }
}
