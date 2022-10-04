/*
    Implementare una classe che rappresenti le caratteristiche e le funzionalità 
    di un computer. Di questa classe implementare due metodi, uno che stampi le 
    caratteristiche dell'oggetto e l'altro per il potenziamento della RAM: dato 
    in ingresso il numero di Gigabyte aggiuntivi ne registri l'incremento sull'oggetto. 
    Implementare, inoltre, all'interno del metodo main più oggetti, cioè più computer 
    con caratteristiche diverse e per ogni caso richiamare i metodi.
*/

import java.util.Scanner;

public class Computer {
    private String cpu, motherboard, gpu, psu, cooler, chassis;
    private int ssd, hdd;
    private int[] ramSlots, ssdSize, hddSize;
    private int ramSlotsUsed;
    private int ramSlotsTotal;
    private Scanner input = new Scanner(System.in);

    public Computer(String cpu, String motherboard, String gpu, String psu, String cooler, String chassis, int ssd, int hdd, int[] ramSlots, int[] ssdSize, int[] hddSize, int ramSlotsUsed, int ramSlotsTotal) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.gpu = gpu;
        this.psu = psu;
        this.cooler = cooler;
        this.chassis = chassis;
        this.ssd = ssd;
        this.hdd = hdd;
        this.ramSlotsTotal = ramSlotsTotal;
        if(ramSlotsTotal <= 0) {
            System.out.println("It's impossible that the slots are less or equal to 0!");
            System.exit(1);
        } else if(ramSlotsUsed > ramSlotsTotal) {
            System.out.println("The RAM slots are more than the total RAM slots!");
            System.exit(1);
        } else {
            this.ramSlotsUsed = ramSlotsUsed;
        }
        if(ramSlots.length == 0 || ramSlots.length != ramSlotsTotal) {
            System.out.println("The quantity of the RAM sizes is wrong!");
            System.exit(1);
        } else {
            this.ramSlots = ramSlots;
        }
        if(ssdSize.length != ssd) {
            System.out.println("The quantity of the SSD sizes is wrong!");
            System.exit(1);
        } else {
            this.ssdSize = ssdSize;
        }
        if(hddSize.length != hdd) {
            System.out.println("The quantity of the HDD sizes is wrong!");
            System.exit(1);
        } else {
            this.hddSize = hddSize;
        }
    }

    public void printSpecs() {
        System.out.println("CPU: " + cpu);
        System.out.println("Motherboard: " + motherboard);
        System.out.println("GPU: " + gpu);
        System.out.println("PSU: " + psu);
        System.out.println("Cooler: " + cooler);
        System.out.println("Chassis: " + chassis);
        System.out.println("SSD: " + ssd);
        if(ssd > 0) {
            for(int i = 0; i < ssdSize.length; i++) {
                System.out.println("Size of SSD " + (i + 1) + ": " + ssdSize[i] + "GB");
            }
        }
        System.out.println("HDD: " + hdd);
        if(hdd > 0) {
            for(int i = 0; i < hddSize.length; i++) {
                System.out.println("Size of HDD " + (i + 1) + ": " + hddSize[i] + "GB");
            }
        }
        System.out.println("RAM Slots: " + ramSlotsTotal);
        System.out.println("RAM Slots Used: " + ramSlotsUsed);
        for(int i = 0; i < ramSlots.length && ramSlots[i] > 0; i++) {
            System.out.println("Size of RAM slot " + (i + 1) + ": " + ramSlots[i] + "GB");
        }
    }

    public void upgradeRam(int newSize) {
        if(ramSlotsUsed == ramSlotsTotal) {
            System.out.println("The RAM slots are full, select which slot you want to replace: ");
            for(int i = 0; i < ramSlotsTotal; i++) {
                System.out.println((i+1) + ") " + ramSlots[i] + "GB");
            }
            System.out.println((ramSlotsTotal+1) + ") Cancel");
            System.out.print("\nYour choice: ");
            int scelta = input.nextInt();
            if(scelta == ramSlotsTotal+1) {
                System.out.println("Ok, I'm cancelling the operation...");
            } else if(scelta > ramSlotsTotal+1 || scelta < 1) {
                System.out.println("Wrong choice, cancelling...");
            } else {
                ramSlots[scelta-1] = newSize;
            }
        } else {
            ramSlots[ramSlotsUsed] = newSize;
            ramSlotsUsed++;
        }
    }
}