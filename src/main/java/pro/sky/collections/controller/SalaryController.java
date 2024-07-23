package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.service.SalaryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/max=salary")
    public Employee getMax(int department) {
        return salaryService.getMaxDepartmentSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee getMin(int department) {
        return salaryService.getMinDepartmentSalary(department);
    }
    @GetMapping(value = "/all", params = "department")
    public List<Employee> all(int department) {
        return salaryService.getEmployeesInDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllByDpt() {
        return salaryService.getAllEmployeeByDepartment();
    }
}
