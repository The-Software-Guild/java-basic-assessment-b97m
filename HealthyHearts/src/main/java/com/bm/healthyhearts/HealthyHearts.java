/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: Computes healthy heart rates for a given age
 */

package com.bm.healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("What is your age?");
        int age = Integer.parseInt(reader.nextLine());
        int maxHR = 220 - age;
        System.out.format(
            "Your maximum heart rate should be %d beats per minute%n",
            maxHR
        );
        
        System.out.format(
           "Your target HR zone is %.2f - %.2f beats per minute",
           0.5 * maxHR,
           0.85 * maxHR
        );
        reader.close();
    }
}
