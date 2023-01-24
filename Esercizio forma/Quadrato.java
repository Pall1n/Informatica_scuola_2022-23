public class Quadrato extends Forma {
    public Quadrato(String nome, double lato) {
        super(nome);
        super.perimetro = lato * 4;
        super.area = lato * lato;
    }
}
