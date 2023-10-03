package Employee_Management_System.user;

import Employee_Management_System.user.Employee;
import Employee_Management_System.user.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {

        return (List<Employee>) employeeRepository.findAll();

    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByName = employeeRepository.findEmployeeByName(employee.getName());
        if(employeeByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer employeeId) {
        boolean employeeExist = employeeRepository.existsById(employeeId);
        if (!employeeExist){
            throw new IllegalStateException("Employee does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    //non-query based method, changed
    @Transactional
    public void updateEmployeeName(Integer employeeId, String name) {
        if (employeeRepository.findById(employeeId).isPresent()){
            Employee employee = employeeRepository.findById(employeeId).get();
            employee.setName(name);
            employeeRepository.save(employee);
        }
        else{
            throw new IllegalArgumentException("Employee with ID " + employeeId + " doesn't exist");
        }
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(Math.toIntExact(id));
    }

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
