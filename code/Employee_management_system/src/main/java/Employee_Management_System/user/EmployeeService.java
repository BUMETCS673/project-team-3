package Employee_Management_System.user;

import Employee_Management_System.credential.Credential;
import Employee_Management_System.credential.CredentialRepository;
import Employee_Management_System.credential.CredentialService;
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

    @Autowired
    private CredentialRepository credentialRepository;


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

    //non-query based method
    @Transactional
    public void updateEmployeeName(Integer employeeId, String name) {

        Employee employee = employeeRepository.findById(employeeId).get();

        employee.setName(name);

    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(Math.toIntExact(id));
    }

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Optional<Employee> getEmployeeByUsername(String username){
        Optional<Credential> cred = credentialRepository.findByUsername(username);
        String name = cred.get().getFirstname();
        return employeeRepository.findEmployeeByName(name);
    }
}
