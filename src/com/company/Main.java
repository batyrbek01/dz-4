package com.company;

import java.util.Random;

public class Main {
    //test
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic"};
    public static int[] heroesHeals = {270, 280, 260, 290};
    public static int[] heroesDamage = {20, 15, 25, 0};
    public static int bossHeals = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";


    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistic();
        while (!isGamefinished()) {
            round();
        }

    }

    public static void round() {
        roundNumber++;
        bossHits();
        heroesHits();
        printStatistic();
        isGamefinished();
        printStatistic();
        heal();
        chooseDefenceType();
        printStatistic();
    }

    public static boolean isGamefinished() {
        if (bossHeals <= 0) {
            System.out.println("Heroes won");
            return true;
        }


        boolean allheroesDead = true;
        for (int i = 0; i < heroesHeals.length; i++) {
            if (heroesHeals[i] > 0) {
                allheroesDead = false;
                break;
            }
        }
        if (allheroesDead){
            System.out.println("Boss won");
        }
        return allheroesDead;
    }


    private static void bossHits() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHeals[i]<bossDamage){
                heroesHeals[i]=0;
            } else
                heroesHeals[i] = heroesHeals[i] - bossDamage;
        }
    }

    private static void heroesHits() {
        for (int i = 0; i < heroesDamage.length; i++) {

            if (heroesHeals[i]>0 && bossHeals>0) {
            }
            bossHeals = bossHeals - heroesDamage[i];
        }

    }



    private static void printStatistic() {
        System.out.println("********" + roundNumber +"ROUND *******");
        System.out.println("Boss heals: "+ bossHeals +"["+bossDamage+"]");

        for (int i = 0; i <heroesHeals.length ; i++) {
            System.out.println("Hero "+heroesAttackType[i] +
                    "Heals " + heroesHeals [i] +
                    "[" + heroesDamage [i] + "]");

        }

    }
    public static void heal(){
        int low = 0;
        for (int i = 0;i<heroesHeals.length;i++){
            for (int j = 0;j <heroesHeals.length;j++){
                if (heroesHeals[i]>heroesHeals[j]){
                    low = j;
                }
            }
        }
        System.out.println("------");
        System.out.println(heroesHeals[low]);
        heroesHeals[low]+=100;
        System.out.println(heroesHeals[low]);
        System.out.println("------");
    }








    public static void chooseDefenceType(){
        Random random = new Random();
        int randomIndex = random.nextInt(3);
    }
}