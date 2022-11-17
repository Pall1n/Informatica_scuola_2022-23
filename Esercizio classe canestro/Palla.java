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

    public void launch() {
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
                    move = (int) Math.floor(Math.random() * 4);
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
                    if ((new_position[0] == target_position[0] && new_position[1] == target_position[1])) {
                        System.out.println("Target hitted! Coordinates: " + new_position[0] + ", " + new_position[1]);
                        System.exit(0);
                    }
                    switch(move) {
                        case 0:
                            old_position = new_position;
                            if (new_position[0]+speed < map_coord[0]) {
                                new_position[0] += speed;
                            } else {
                                new_position[0] = map_coord[0]-1;
                                move = 1;
                            }
                            if (target_position[0] >= old_position[0] && target_position[0] <= new_position[0]) {;
                                new_position[0] = target_position[0];
                            }
                            break;
                        case 1:
                            old_position = new_position;
                            if (new_position[0]-speed >= 0) {
                                new_position[0] -= speed;
                            } else {
                                new_position[0] = 0;
                                move = 0;
                            }
                            if (target_position[0] <= old_position[0] && target_position[0] >= new_position[0]) {;
                                new_position[0] = target_position[0];
                            }
                            break;
                        case 2:
                            old_position = new_position;
                            if (new_position[1]+speed < map_coord[1]) {
                                new_position[1] += speed;
                            } else {
                                new_position[1] = map_coord[1]-1;
                                move = 3;
                            }
                            if (target_position[1] >= old_position[1] && target_position[1] <= new_position[1]) {;
                                new_position[1] = target_position[1];
                            }
                            break;
                        case 3:
                            old_position = new_position;
                            if (new_position[1]-speed >= 0) {
                                new_position[1] -= speed;
                            } else {
                                new_position[1] = 0;
                                move = 2;
                            }
                            if (target_position[1] >= old_position[1] && target_position[1] <= new_position[1]) {;
                                new_position[1] = target_position[1];
                            }
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
        for (int i = map_coord[1]-1; i >= 0; i--) {
            for (int j = 0; j < map_coord[0]; j++) {
                if (i == new_position[0] && j == new_position[1]) {
                    System.out.print("^");
                } else if (i == target_position[0] && j == target_position[1]) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}