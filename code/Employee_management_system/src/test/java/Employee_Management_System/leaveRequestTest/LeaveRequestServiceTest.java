package Employee_Management_System.leaveRequestTest;

import Employee_Management_System.LeaveRequest.LeaveRequest;
import Employee_Management_System.LeaveRequest.LeaveRequestRepository;
import Employee_Management_System.LeaveRequest.LeaveRequestService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@Disabled
class LeaveRequestServiceTest {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;


    @Test
    public void testAddLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest(1, 1, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        Assertions.assertThat(savedLeaveRequest).isNotNull();
        Assertions.assertThat(savedLeaveRequest.getId()).isGreaterThan(0);
    }


    @Test
    public void testFindLeaveRequestById() {
        LeaveRequest leaveRequest = new LeaveRequest(4, 4,LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(savedLeaveRequest.getId());

        Assertions.assertThat(foundLeaveRequest).isPresent();
    }

    @Test
    public void testGetAllLeaveRequests() {
        LeaveRequest leaveRequest1 = new LeaveRequest(2,2, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest leaveRequest2 = new LeaveRequest(3,3, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");

        leaveRequestRepository.save(leaveRequest1);
        leaveRequestRepository.save(leaveRequest2);

        List<LeaveRequest> allLeaveRequests = leaveRequestRepository.findAll();

        Assertions.assertThat(allLeaveRequests).hasSizeGreaterThan(0);
    }


    @Test
    public void testUpdateLeaveRequestStatus() {

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(4);
        LeaveRequest leaveRequest = foundLeaveRequest.get();
        leaveRequest.setReason("test");
        LeaveRequest updatedLeaveRequest = leaveRequestRepository.saveAndFlush(leaveRequest);

        Assertions.assertThat(updatedLeaveRequest.getReason()).isEqualTo("test");
    }

    @Test
    public void testDeleteLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest(6,6,LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        leaveRequestRepository.deleteById(savedLeaveRequest.getId());
        leaveRequestRepository.deleteById(4);

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(savedLeaveRequest.getId());

        Assertions.assertThat(foundLeaveRequest).isNotPresent();
    }


    @Test
    public void testApprovalAndRejections() {

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(3);
        LeaveRequest leaveRequest = foundLeaveRequest.get();
        leaveRequest.setStatus("Approved");
        LeaveRequest updatedLeaveRequest = leaveRequestRepository.saveAndFlush(leaveRequest);

        Assertions.assertThat(updatedLeaveRequest.getStatus()).isEqualTo("Approved");

        leaveRequest.setStatus("Rejections");
        LeaveRequest updatedLeaveRequest1 = leaveRequestRepository.saveAndFlush(leaveRequest);
        Assertions.assertThat(updatedLeaveRequest1.getStatus()).isEqualTo("Rejections");

    }

}


