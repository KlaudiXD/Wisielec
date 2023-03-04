package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        String [] tab={"pies","kot","bocian","krowa","chomik"};
        String randomWord= tab[getRandom()];
        System.out.println(randomWord);
        int maxErrors=10;
        int userError=0;
        char [] arr= randomWord.toCharArray();
        char [] arrTwo= new char[arr.length];
        System.out.println("To jest gra wisielec :)");
        System.out.println("Zgadnij wylosowane słowo: ");
        fill(arrTwo);
        print(arrTwo);
        while(userError <= maxErrors){
            System.out.println();
            String input = scanner.next();
            char ch = input.charAt(0);
            int countLetters=0;
            for (int i = 0; i < arr.length; i++) {
                if(ch == arr[i]){
                    arrTwo[i] = ch;
                } else{ countLetters++;

                }
            }
            if (countLetters==arrTwo.length){
                userError++;
            }
            countLetters=0;
            System.out.println(userError);
            if(userError == 10){
                System.out.println("Przegrałeś");
            }

            print(arrTwo);
        }



    }
    public static int getRandom(){
        int random= (int) (Math.random()*5);
        return random;
    }
    public static void fill (char [] cha){
        for (int i = 0; i < cha.length; i++) {
            cha[i]= '_';
        }
    }
    public static void print (char [] cha){
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i]);
        }
    }

}
