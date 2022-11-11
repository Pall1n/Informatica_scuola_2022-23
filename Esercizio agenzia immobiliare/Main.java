public class Main {
    public static void main(String[] args) throws Exception{
        Immobile immobile = new Immobile("residenza", 100, 15);
        System.out.println("Valore immobile: " + immobile.getValoreImmobile() + " euro");
        System.out.println("Tasse di registro: " + immobile.getTasseRegistro() + " euro");
        System.out.println("Canone di affitto: " + immobile.getCanoneAffitto() + " euro");
    }
}
