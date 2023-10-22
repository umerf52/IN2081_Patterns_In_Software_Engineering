package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Employee {
    private List<Employee> supervisedEmployees = new ArrayList<>();

    public Supervisor(String name) {
        super(name);
    }

    public List<Employee> getSupervisedEmployees() {
        return supervisedEmployees;
    }

    public void setSupervisedEmployees(List<Employee> supervisedEmployees) {
        this.supervisedEmployees = supervisedEmployees;
    }

    @Override
    public void listHierarchy(int level) {
        printName(level);
        for (Employee employee : supervisedEmployees) {
            employee.listHierarchy(level + 1);
        }
    }

    public void hireEmployee(Employee employee) {
        supervisedEmployees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        supervisedEmployees.remove(employee);
    }


    // TODO 2: Implement the Supervisor class

    // TODO 3: Implement listHierarchy() for Supervisor
}
