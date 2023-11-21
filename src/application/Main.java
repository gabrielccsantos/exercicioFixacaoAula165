package application;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = read.nextInt();
        read.nextLine();

        for(int i = 1; i <= numberOfPayers; i++){
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char letter = read.nextLine().toLowerCase().charAt(0);
            System.out.print("Name: ");
            String nameEmployee = read.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = read.nextDouble();

            if(letter == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = read.nextDouble();

                personList.add(new NaturalPerson(nameEmployee, anualIncome, healthExpenditures));
            }
            else if(letter == 'c'){
                System.out.print("Numbers of Employees: ");
                int numberOfEmployee = read.nextInt();

                personList.add(new LegalPerson(nameEmployee, anualIncome, numberOfEmployee));
            }
            read.nextLine();
        }

        System.out.println("TAX PAID: ");
        double sum = 0;
        for(Person person : personList){
            sum += person.calculateTax();
            System.out.println(person);
        }

        System.out.printf("TOTAL TAX : $%.2f", sum);

        read.close();
    }
}