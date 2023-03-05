package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        // Utworzenie tabeli haseł
        String [] tab={"pies","kot","bocian","krowa","chomik"};
        //wybranie hasła za pomocą losowego indexu
        String randomWord= tab[getRandom()];
        System.out.println(randomWord);
        //określenie max liczby błędów gracza
        int maxErrors=10;
        int userError=0;
        //zamiana słowa na tablicę char
        char [] arr= randomWord.toCharArray();
        char [] arrTwo= new char[arr.length];
        System.out.println("To jest gra wisielec :)");
        System.out.println("Zgadnij wylosowane słowo: ");
        fill(arrTwo);
        print(arrTwo);
        //pętla, która zostaje wykonana dpóki gracz wygra lub przegra
        while(userError <= maxErrors){
            System.out.printf("Popełniłeś %d z %d błędów",userError,maxErrors);
            System.out.println();
            String input = scanner.next();
            char letter = input.charAt(0);
            int countLetters=0;
            //sprawdzenie, czy wybrana litera jest w haśle lub jej wcale tam nie ma
            for (int i = 0; i < arr.length; i++) {
                if(letter == arr[i]){
                    arrTwo[i] = letter;
                } else{
                    countLetters++;
                }
            }
            if (countLetters==arrTwo.length){
                userError++;
            }
            countLetters=0;
            if(userError == maxErrors){
                System.out.println("Przegrałeś");
                break;
            }
            print(arrTwo);
            if (checkWin(arr, arrTwo)){
                System.out.println("Wygrałeś");
                break;
            }

        }


    }
    //losowanie randomowej cyfry
    public static int getRandom(){
        int random= (int) (Math.random()*5);
        return random;
    }
    //wypełnienie dodatkowej tablicy podkreślnikami
    public static void fill (char [] cha){
        for (int i = 0; i < cha.length; i++) {
            cha[i]= '_';
        }
    }
   //wydrukowanie tablicy
    public static void print (char [] cha){
        System.out.print("Słowo do zgadnięcia: ");
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i]);
        }
        System.out.println();
    }
    //sprawdzenie warunku zwycięstwa
    public static boolean checkWin (char [] original,char [] check){
        int countWin = 0;
        for (int i = 0; i < original.length; i++) {
            if(original[i] == check[i]){
                countWin++;
            }
        }
        return countWin==original.length;
    }


}
