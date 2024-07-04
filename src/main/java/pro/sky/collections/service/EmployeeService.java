package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.*;
@Service
public class EmployeeService {
    private final int maximumEmployees = 10;
    private List<Employee> allEmployees = new ArrayList<>(maximumEmployees);


    public List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public Employee addPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (allEmployees.size() >= maximumEmployees) {
            throw new EmployeeStorageIsFullException();
        } else if (allEmployees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            allEmployees.add(employee);
        }
        return employee;
    }

    public Employee deletePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!allEmployees.contains(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            allEmployees.remove(employee);
        }
        return employee;
    }

    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!allEmployees.contains(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }
    }

}

