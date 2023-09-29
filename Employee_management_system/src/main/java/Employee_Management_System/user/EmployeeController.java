package Employee_Management_System.user;


import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id ){
       var employee = employeeService.getEmployeeById(id);
       if (employee.isPresent()){
           return employee;
       }else{
           throw new ResourceNotFoundException("Cannot find employee with id: "+ id);
       }
    }


    @PutMapping("/employee/{id}")
    public Optional<Employee> updateEmployeeJobTitle(@RequestBody Employee newEmployee, @PathVariable Long id) throws Exception {

        return Optional.ofNullable(employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setJobTitle(newEmployee.getJobTitle());
                    employee.setAnnualSalary(newEmployee.getAnnualSalary());
                    return employeeService.save(employee);
                }).orElseThrow(() -> new Exception("Cannot find employee with id: "+ id)));

    }


}
