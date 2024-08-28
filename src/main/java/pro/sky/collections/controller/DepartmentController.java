package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max=salary")
    public Employee getMax(@PathVariable int department) {
        return departmentService.getMaxDepartmentSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee getMin(@PathVariable int department) {
        return departmentService.getMinDepartmentSalary(department);
    }

    @GetMapping("/combined-salary")
    public double getAllSalary(@PathVariable int department) {
        return departmentService.getSalaryInDepartmentSum(department);
    }

    @GetMapping(value = "/all", params = "department")
    public List<Employee> all(@PathVariable int department) {
        return departmentService.getEmployeesInDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllByDpt() {
        return departmentService.getAllEmployeeByDepartment();
    }
}
