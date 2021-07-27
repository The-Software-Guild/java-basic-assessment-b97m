/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: Randomly generate dog genetic data
 */

package com.bm.doggenetics;

import java.util.Random;
import java.util.Scanner;


public class DogGenetics {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        Random randGen = new Random();
        
        System.out.println("What is your dog's name?");
        String dogName = reader.nextLine();
        
        String[] breedNames = {
            "St. Bernard",
            "Chihuahua",
            "Dramatic RedNosed Asian Pug",
            "Common Cur",
            "King Doberman"
        };
        double[] breedPortions = new double[5];
        double portionSum = 0;
        
        for (int i = 0; i < 5; i++) {
            breedPortions[i] = 0.1 + randGen.nextDouble();
            portionSum += breedPortions[i];
        }
        
        
        System.out.print("well then, I have this highly ");
        System.out.print("reliable report on " + dogName + "'s ");
        System.out.println("prestigious background right here.");        
        System.out.println();
        System.out.println(dogName + " is: ");
        System.out.println();
        
        for (int i = 0; i < 5; i++) {
            double percentage = breedPortions[i] * 100 / portionSum;
            System.out.println(percentage + "% " + breedNames[i]);
        }
    
        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");
    }
}
