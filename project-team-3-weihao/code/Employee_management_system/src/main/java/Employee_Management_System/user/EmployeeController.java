package Employee_Management_System.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allemployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeID}")
    public void deleteEmployee(@PathVariable Integer employeeID){
        employeeService.deleteEmployeeById(employeeID);
    }

    @PutMapping("{employeeId}")
    public void updateEmployeeName(
            @PathVariable Integer employeeId,
            @RequestParam(required = false) String name
    ){
        employeeService.updateEmployeeName(employeeId, name);
    }









}
