package pro.sky.collections.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collections.Employee;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAllEmployees())
                .thenReturn(List.of(
                        new Employee("Ivan", "Ivanov", 1, 10200),
                        new Employee("Dan", "Bell", 1 , 10200),
                        new Employee("Sergio", "Martinez-Kawasaki", 2, 10090.0),
                        new Employee("Borjes", "Trinidad", 2, 10300.0)
                ));
    }

    @Test
    void sumTest() {
        //List<Employee> employees = employeeService.getAllEmployees();
        //System.out.println(employees);

        double actual = departmentService.getSalaryInDepartmentSum(1);
         Assertions.assertEquals(20400, actual);
    }

    @Test
    void minTest() {
        Employee actualEmployee = departmentService.getMinDepartmentSalary(2);
        double actual = actualEmployee.getSalary();
        Assertions.assertEquals(10090, actual);
    }

    @Test
    void maxTest() {
        Employee actualEmployee = departmentService.getMaxDepartmentSalary(2);
        double actual = actualEmployee.getSalary();
        Assertions.assertEquals(10300, actual);
    }

    @Test
    void getAllTest() {
        List<Employee> actual = departmentService.getEmployeesInDepartment(1);
         Assertions.assertEquals(2, actual.size());
    }

    @Test
    void groupingTest() {
        Map<Integer, List<Employee>> actual = departmentService.getAllEmployeeByDepartment();
        Assertions.assertEquals(2, actual.keySet().size());
    }
}
