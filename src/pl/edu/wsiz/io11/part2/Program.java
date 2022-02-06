package pl.edu.wsiz.io11.part2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company(new FileLogger("company-log.txt"));

        company.addEmployee(new Developer("Jan", "Kowalski", (byte) 31, Sex.MALE, 3000, new String[]{"HTML"}));
        company.addEmployee(new Manager("Anna", "Kowalczyk", (byte) 27, Sex.FEMALE, 4000, new String[]{"Java", "CSS"}, 14));
        company.addEmployee(new Developer("Piotr", "Nowak", (byte) 36, Sex.MALE, 2800, new String[]{"CSS", "PHP"}));

        int operationNumber;
        do {
            System.out.println("Lista operacji:\n");
            System.out.println("1 - wypisz listę pracowników");
            System.out.println("2 - dodaj programistę");
            System.out.println("3 - dodaj kierownika");
            System.out.println("4 - usuń pracownika");
            System.out.println("9 - zakończ program\n");

            System.out.print("Podaj numer operacji: ");
            operationNumber = scanner.nextInt();

            switch (operationNumber) {
                case 1:
                    company.printEmployees();
                    break;
                case 2:
                    company.addDeveloper();
                    break;
                case 3:
                    company.addManager();
                    break;
                case 4:
                    System.out.print("Podaj numer pracownika do usunięcia: ");
                    int employeeNumber = scanner.nextInt();
                    company.removeEmployee(employeeNumber);
                    break;
                case 9:
                    // nic nie rób (zakończ pętlę)
                    break;
                default:
                    System.out.println("Operacja o podanym numerze nie istnieje!");
            }

        } while (operationNumber != 9);
    }
}