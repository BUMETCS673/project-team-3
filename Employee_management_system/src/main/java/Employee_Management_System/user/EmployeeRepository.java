package Employee_Management_System.user;

import Employee_Management_System.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("select e from Employee e where e.id = ?1")
    Optional<Employee> findEmployeeById(Integer id);

    @Query("select e from Employee e where e.name = ?1")
    Optional<Employee> findEmployeeByName(String name);




}
