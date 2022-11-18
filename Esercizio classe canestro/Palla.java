import java.io.IOException;

public class Palla {
    private int[] coordinate_palla = new int[2];
    private int[] ex_coordinate_palla = new int[2];
    private int[] dimensioni_griglia = new int[2];

    public Palla(int[] griglia) {
        this.dimensioni_griglia = griglia;
        this.coordinate_palla[0] = (int) (Math.random() * dimensioni_griglia[0]);
        this.coordinate_palla[1] = (int) (Math.random() * dimensioni_griglia[1]);
    }

    public int[] get_coordinate() {
        return coordinate_palla;
    }

    public int[] get_ex_coordinate() {
        return ex_coordinate_palla;
    }

    public boolean muovi_sopra(int speed) {
        ex_coordinate_palla = coordinate_palla;
        if (coordinate_palla[1]+speed < dimensioni_griglia[1]) {
            coordinate_palla[1] += speed;
        } else {
            coordinate_palla[1] = dimensioni_griglia[1]-1;
            return false;
        }
        return true;
    }

    public boolean muovi_sotto(int speed) {
        ex_coordinate_palla = coordinate_palla;
        if (coordinate_palla[1]-speed >= 0) {
            coordinate_palla[1] -= speed;
        } else {
            coordinate_palla[1] = 0;
            return false;
        }
        return true;
    }

    public boolean muovi_destra(int speed) {
        ex_coordinate_palla = coordinate_palla;
        if (coordinate_palla[0]+speed < dimensioni_griglia[0]) {
            coordinate_palla[0] += speed;
        } else {
            coordinate_palla[0] = dimensioni_griglia[0]-1;
            return false;
        }
        return true;
    }

    public boolean muovi_sinistra(int speed) {
        ex_coordinate_palla = coordinate_palla;
        if (coordinate_palla[0]-speed >= 0) {
            coordinate_palla[0] -= speed;
        } else {
            coordinate_palla[0] = 0;
            return false;
        }
        return true;
    }
}