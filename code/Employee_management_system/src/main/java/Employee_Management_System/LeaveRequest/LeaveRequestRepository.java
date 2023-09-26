package Employee_Management_System.LeaveRequest;

import Employee_Management_System.credential.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    Optional<LeaveRequest> findByUsername(String username);
}
