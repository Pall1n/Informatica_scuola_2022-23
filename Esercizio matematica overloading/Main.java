public class Main {
    public static void main(String[] args) {
        Matematica math = new Matematica();
        System.out.println(math.somma(1, 2));
        System.out.println(math.somma(1, 2, 3));
        System.out.println(math.sottrazione(7, 2));
        System.out.println(math.sottrazione(5, 2, 3));
        System.out.println(math.radiceSomma(2, 2));
        System.out.println(math.radiceSomma(5, 10, 10));
    }
}