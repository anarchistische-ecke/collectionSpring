package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;
import pro.sky.collections.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public EmployeeService add(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.addPerson(firstName, lastName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            e.printStackTrace();
        }
        return employeeService;
    }

    @GetMapping("/remove")
    public EmployeeService deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.deletePerson(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return employeeService;
    }

    @GetMapping("/find")
    public EmployeeService findPerson(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            employeeService.findPerson(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return employeeService;
    }

    @GetMapping("/listAll")
    public EmployeeService listAllEmployees() {
        return (EmployeeService) employeeService.getAllEmployees();
    }

}
