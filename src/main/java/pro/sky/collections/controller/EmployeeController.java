package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return employeeService.addPerson(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee deletePerson(@RequestParam String firstName, @RequestParam  String lastName, @RequestParam int department, @RequestParam double salary) {
        return employeeService.deletePerson(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return employeeService.findPerson(firstName, lastName, department, salary);
    }

    @GetMapping("/listAll")
    public List<Employee> listAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
