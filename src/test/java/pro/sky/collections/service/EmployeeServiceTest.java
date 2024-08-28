package pro.sky.collections.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeNotFoundException;

import java.util.Collection;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    void init() {
        employeeService.addPerson("Pavel", "Petrushka", 1, 100500);
        employeeService.addPerson("Wolk", "Odinokiy", 9, 101501);
    }

    @AfterEach
    void clear() {
        employeeService = new EmployeeService();
    }

    @Test
    void findAllTest() {
        Collection<Employee> actual = employeeService.getAllEmployees();
        Assertions.assertEquals(2, actual.size());
    }

    @Test
    void find() {
        Employee actual = employeeService.findPerson("Pavel", "Petrushka", 1, 100500);
        Assertions.assertEquals("Pavel", actual.getFirstName());
        Assertions.assertEquals("Petrushka", actual.getLastName());
    }

    @Test
    void find_negative() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findPerson("Ivan", "Ivanovka", 2, 1500));
    }

    @Test
    void remove() {
        int size = employeeService.getAllEmployees().size();
        employeeService.deletePerson("Pavel", "Petrushka", 1, 100500);
        Assertions.assertEquals(size = 1, employeeService.getAllEmployees().size());
    }
}
