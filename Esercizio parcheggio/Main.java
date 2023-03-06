import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Parcheggio parcheggio = new Parcheggio();
        boolean continua = true;
        int scelta;

        while(continua) {
            System.out.print("Cosa vuoi fare? (1 per aggiungere un veicolo, 2 per rimuoverlo, 3 per stampare il parcheggio, 0 per uscire): ");

            while(!input.hasNextInt()) {
                System.out.print("Inserisci un numero: ");
                input.next();
            }
            scelta = input.nextInt();

            switch(scelta) {
                case 1:
                    System.out.print("Che tipo di veicolo vuoi aggiungere? (1 per auto, 2 per furgone, 3 per moto): ");
                    while(!input.hasNextInt()) {
                        System.out.print("Inserisci un numero: ");
                        input.next();
                    }
                    scelta = input.nextInt();

                    System.out.print("Inserisci il motore: ");
                    String motore = input.next();

                    System.out.print("Inserisci la targa: ");
                    String targa = input.next();

                    System.out.print("Inserisci la marca: ");
                    String marca = input.next();

                    System.out.print("Inserisci il nome: ");
                    String nome = input.next();

                    switch(scelta) {
                        case 1:
                            System.out.print("Inserisci il numero di posti: ");
                            while(!input.hasNextInt()) {
                                System.out.print("Inserisci un numero: ");
                                input.next();
                            }
                            int posti = input.nextInt();

                            System.out.print("Inserisci il numero di porte: ");
                            while(!input.hasNextInt()) {
                                System.out.print("Inserisci un numero: ");
                                input.next();
                            }
                            int porte = input.nextInt();

                            parcheggio.addVeicolo(new Auto(motore, targa, marca, nome, posti, porte));
                            break;
                        case 2:
                            System.out.print("Inserisci la capacità: ");
                            while(!input.hasNextInt()) {
                                System.out.print("Inserisci un numero: ");
                                input.next();
                            }
                            int capacita = input.nextInt();

                            parcheggio.addVeicolo(new Furgone(motore, targa, marca, nome, capacita));
                            break;
                        case 3:
                            System.out.print("Inserisci la cilindrata: ");
                            while(!input.hasNextInt()) {
                                System.out.print("Inserisci un numero: ");
                                input.next();
                            }
                            int cilindrata = input.nextInt();

                            parcheggio.addVeicolo(new Moto(motore, targa, marca, nome, cilindrata));
                            break;
                        default:
                            System.out.println("Scelta non valida!");
                    }
                    break;
                case 2:
                    System.out.print("Inserisci il numero del posto del veicolo da rimuovere: ");
                    while(!input.hasNextInt()) {
                        System.out.print("Inserisci un numero: ");
                        input.next();
                    }
                    try{
                        if(parcheggio.removeVeicolo(input.nextInt())) {
                            System.out.println("Veicolo rimosso con successo!");
                        } else {
                            System.out.println("Il posto inserito è vuoto!");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Il posto inserito non esiste!");
                    }
                    break;
                case 3:
                    parcheggio.getParcheggio();
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }

            System.out.println();
        }

        input.close();
    }
}