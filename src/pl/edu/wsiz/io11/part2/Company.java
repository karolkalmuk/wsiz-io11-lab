package pl.edu.wsiz.io11.part2;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employeesArrayList = new ArrayList<>();
    private FileLogger logger;

    public Company(FileLogger logger) {
        this.logger = logger;
    }

    public void addEmployee(Employee employee) {
        if (isAlreadyOnTheList(employee)) {
            logger.error("Próba dodanie pracownika o tych samych danych: " + employee);
            return;
        }

        employeesArrayList.add(employee);
        logger.info("Pracownik dodany (" + employee + ")");
    }

    public void addDeveloper() {
        addEmployee(Developer.read());
    }

    public void addManager() {
        addEmployee(Manager.read());
    }

    public void removeEmployee(int number) {
        if (number < 1 || number > employeesArrayList.size()) {
            logger.error("Próba usunięcia pracownika o niepoprawnym numerze porządkowym: " + number);
            return;
        }

        Employee employee = employeesArrayList.remove(number - 1);
        logger.info("Pracownik usunięty (" + employee + ")");
    }

    private boolean isAlreadyOnTheList(Employee employee) {
        for (Employee tmpEmployee : employeesArrayList) {
            if (tmpEmployee.isEqual(employee)) {
                return true;
            }
        }

        return false;
    }

    public void printEmployees() {
        System.out.println("--------------------");

        int number = 1;
        for (Employee employee : employeesArrayList) {
            System.out.print(number++ + "  ");
            employee.print();
        }

//        for (Employee employee : employeesArrayList) {
//            System.out.print(employeesArrayList.indexOf(employee) + 1 + "  ");
//            employee.print();
//        }

//        for (int i = 0; i < employeesArrayList.size(); i++) {
//            System.out.print(i + 1 + "  ");
//            employeesArrayList.get(i).print();
//        }

        System.out.println("--------------------");
    }
}
