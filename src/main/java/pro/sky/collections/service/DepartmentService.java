package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;

import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMinDepartmentSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMaxDepartmentSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeesInDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }
// collects all employees to a map with a key being a dpt id and a value being a list of employees of that dpt
    public Map<Integer, List<Employee>> getAllEmployeeByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public double getSalaryInDepartmentSum(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
