package Ch2;

import java.awt.*;
import java.util.Scanner;

public class MadLibs {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an adjective:");
        String adj = scanner.nextLine();

        System.out.println("Enter a season of the year:");
        String season = scanner.nextLine();

        System.out.println("Enter an number:");
        int num = scanner.nextInt();

        System.out.printf("On a %s %s day, I drink a minimum of %d cups of coffee", adj, season, num);
    }
}
