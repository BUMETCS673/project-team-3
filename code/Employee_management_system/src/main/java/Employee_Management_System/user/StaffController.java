package Employee_Management_System.user;


import Employee_Management_System.Security.Service.JwtService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Exception.ResourceNotFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("{username}")
    public Optional<Employee> getEmployee(@PathVariable String username){
        var employee = employeeService.getEmployeeByUsername(username);

        if (employee.isPresent()){
            return employee;
        }else{
            throw new ResourceNotFoundException("Cannot find employee with: "+ username);
        }
    }

    @PostMapping
    public String post(){
        return "Post: postmapping";
    }

    @DeleteMapping
    public String del(){
        return "Delete:deletmapping";
    }

    @PutMapping
    public String put(){
        return "Put: upmapping";
    }



}
