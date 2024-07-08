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
    private Map<String, Employee> allEmployees;

    public EmployeeService(Map<String, Employee> allEmployees) {
        this.allEmployees = new HashMap<>();
    }

    public Map<String, Employee> getAllEmployees() {
        return allEmployees;
    }

    public Employee addPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (allEmployees.size() >= maximumEmployees) {
            throw new EmployeeStorageIsFullException();
        } else if (allEmployees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            allEmployees.put(employee.getFullName(), employee);
        }
        return employee;
    }

    public Employee deletePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!allEmployees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            allEmployees.remove(employee.getFullName());
        }
        return employee;
    }

    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!allEmployees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }
    }

}

