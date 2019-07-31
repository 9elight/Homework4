package com.company;

import java.util.Random;

public class Main {
    public static int[] heatpoint = {900, 250, 250, 250, 500,250};
    public static int[] damage = {60, 20, 20, 20, 5, 10};
    public static String[] hitTypes = {"Physical", "Physical", "Magical", "Archer","Tank", "Medical"};

    public static void main(String[] args) {
        roundStat();
        while (!theEnd()) {
            bossDefence();
            round();
            roundStat();

        }
    }

    public static void round() {

        for (int i = 1; i <= 5; i++) {
            if (heatpoint[i] > 0){

            heatpoint[i] = bossDamage(i);}
            else heatpoint[i] = 0;

        }
        for (int i = 1; i <= 4; i++) {
            int healthRemain = heroesDamage(i);
            if (healthRemain < 0) {
                heatpoint[0] = 0;
            }else heatpoint[0] = healthRemain;

        }
        Random r = new Random();
        int randomMedication = r.nextInt(3) + 1;
        heatpoint[randomMedication] = medication(randomMedication);


    }

    public static boolean theEnd() {
        if (heatpoint[0] <= 0) {
            System.out.println("Heroes won");
            return true;
        }
        if (heatpoint[1] <= 0 && heatpoint[2] <= 0 && heatpoint[3] <= 0 && heatpoint[4] <= 0 && heatpoint[5] <= 0) {
            System.out.println("Boss won");
            return true;
        }
        return false;
    }

    public static int bossDamage(int playerInd) {
       if (playerInd != 4){
           if (heatpoint[4] >= 0){
        return heatpoint[playerInd] - damage[0]/2;}}
       else { return heatpoint[playerInd] - damage[0];}
       return heatpoint[playerInd] - damage[0];
    }

    public static int heroesDamage(int playerInd) {

        if (hitTypes[0].equals(hitTypes[playerInd])) {
            Random r = new Random();
            int randomCrit = r.nextInt(4) + 2;
            System.out.println(hitTypes[playerInd] + " damage boss " + damage[playerInd] * randomCrit);
            return heatpoint[0] - damage[playerInd] * randomCrit;


        } else {
            return heatpoint[0] - damage[playerInd];
        }
    }

    public static int medication(int randomHeroes) {
        if (heatpoint[4] > 0){

        System.out.println("Medic heal " + hitTypes[randomHeroes]);
        return heatpoint[randomHeroes] + damage[5];

    }
        return heatpoint[randomHeroes];
    }

    public static void roundStat() {
        System.out.println("____________________");
        System.out.println("Boss heatpoints " + heatpoint[0]);
        System.out.println("Warior heatpoints " + heatpoint[1]);
        System.out.println("Magician heatpoints " + heatpoint[2]);
        System.out.println("Archer heatpoints " + heatpoint[3]);
        System.out.println("Tank heatpoints " + heatpoint[4]);
        System.out.println("Medic heatpoints " + heatpoint[5]);
        System.out.println("_____________________");
    }

    public static void bossDefence() {
        Random r = new Random();
        int randomNumb = r.nextInt(5) + 1;
        hitTypes[0] = hitTypes[randomNumb];

    }


}
