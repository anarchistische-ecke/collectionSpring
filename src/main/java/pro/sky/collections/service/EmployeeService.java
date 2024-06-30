package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.*;
@Service
public class EmployeeService {
    private final int maximumEmployees = 10;
    private List<String> allEmployees = new ArrayList<>(maximumEmployees);

    public EmployeeService(List<String> allEmployees) {
        this.allEmployees = allEmployees;
    }

    public List<String> getAllEmployees() {
        return allEmployees;
    }

    public void addPerson(String firstName, String lastName) {
        if (allEmployees.size() >= maximumEmployees) {
            throw new EmployeeStorageIsFullException();
        } else if (allEmployees.contains(firstName) || (allEmployees.contains(lastName))) {
            throw new EmployeeAlreadyAddedException();
        } else {
            allEmployees.add(firstName);
            allEmployees.add(lastName);
        }
    }

    public void deletePerson(String firstName, String lastName) {
        if (!allEmployees.contains(firstName) || (!allEmployees.contains(lastName))) {
            throw new EmployeeNotFoundException();
        } else {
            allEmployees.remove((String) firstName);
            allEmployees.remove((String) lastName);
        }
    }

    public void findPerson(String firstName, String lastName) {
        if (!allEmployees.contains(firstName) || !allEmployees.contains(lastName)) {
            throw new EmployeeNotFoundException();
        } else {
            allEmployees.get(Integer.parseInt(firstName));
            allEmployees.get(Integer.parseInt(lastName));

        }
    }

}

