import java.io.IOException;

public class Campo {
    private int[] griglia = new int[2];
    private Canestro canestro;
    private Palla palla;
    private int[] coordinate_canestro;
    private int[] coordinate_palla;
    private int mossa_palla;
    private int speed_palla;

    public Campo(int[] griglia, int speed_palla) {
        this.griglia = griglia;
        this.speed_palla = speed_palla;
        this.canestro = new Canestro(griglia);
        this.palla = new Palla(griglia);
    }

    public void match() {
        new Thread() {
            public void run() {
                final String os = System.getProperty("os.name");
                while (true) {
                    printGame();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        
                    if (os.contains("Windows"))
                    {
                        try {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        try {
                            new ProcessBuilder("clear").inheritIO().start().waitFor();
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    mossa_palla = (int) Math.floor(Math.random() * 4);
                    try {
                        Thread.sleep(((int) Math.floor(Math.random()*3)+1)*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    if (canestro.verifica_centro(palla.get_coordinate())) {
                        System.out.println("Target hitted! Coordinates: " + palla.get_coordinate());
                        System.exit(0);
                    }
                    switch(mossa_palla) {
                        case 0:
                            palla.muovi_sopra(speed_palla);
                            break;
                        case 1:
                            palla.muovi_sotto(speed_palla);
                            break;
                        case 2:
                            palla.muovi_destra(speed_palla);
                            break;
                        case 3:
                            palla.muovi_sinistra(speed_palla);
                            break;
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void printGame() {
        coordinate_canestro = canestro.getCoordinate_canestro();
        coordinate_palla = palla.get_coordinate();
        for (int i = griglia[1]-1; i >= 0; i--) {
            for (int j = 0; j < griglia[0]; j++) {
                if (i == coordinate_palla[0] && j == coordinate_palla[1]) {
                    System.out.print("O");
                } else if (i == coordinate_canestro[0] && j == coordinate_canestro[1]) {
                    System.out.print("P");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
