package Employee_Management_System.LeaveRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    // Optional<LeaveRequest> findByUsername(String username);
}
