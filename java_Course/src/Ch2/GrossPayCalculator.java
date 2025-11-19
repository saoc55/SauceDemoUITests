package Ch2;

import java.util.Scanner;

public class GrossPayCalculator {

    public static void main(String arg[]){

        // attributes / Variables
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of working hours: ");
        double workingHours = scanner.nextDouble();

        System.out.println("Enter the horuly pay rate: ");
        double hourlyPayRate = scanner.nextDouble();

        // return Gross Pay
        double Salary = workingHours * hourlyPayRate;
        System.out.println("Your salary is: " + Salary);


    }
}
