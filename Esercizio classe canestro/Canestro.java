public class Canestro {
    private int[] coordinate_canestro = new int[2];
    private int[] dimensioni_griglia = new int[2];

    public Canestro(int[] griglia) {
        this.dimensioni_griglia = griglia;
        this.coordinate_canestro[0] = (int) (Math.random() * dimensioni_griglia[0]);
        this.coordinate_canestro[1] = (int) (Math.random() * dimensioni_griglia[1]);
    }

    public int[] getCoordinate_canestro() {
        return coordinate_canestro;
    }

    public boolean verifica_centro(int[] coordinate_palla) {
        if(coordinate_palla == coordinate_canestro) {
            return true;
        }
        return false;
    }
}
