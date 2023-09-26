package Employee_Management_System.leaveRequest;

import Employee_Management_System.LeaveRequest.LeaveRequest;
import Employee_Management_System.LeaveRequest.LeaveRequestRepository;
import Employee_Management_System.LeaveRequest.LeaveRequestService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class LeaveRequestServiceTest {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    @InjectMocks
    private LeaveRequestService service;

    private LeaveRequestRepository repository;

    @Test
    public void testAddLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest(1, 1, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        Assertions.assertThat(savedLeaveRequest).isNotNull();
        Assertions.assertThat(savedLeaveRequest.getId()).isGreaterThan(0);
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
    public void testFindLeaveRequestById() {
        LeaveRequest leaveRequest = new LeaveRequest(4, 4,LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(savedLeaveRequest.getId());

        Assertions.assertThat(foundLeaveRequest).isPresent();
    }

    @Test
    public void testUpdateLeaveRequestStatus() {
        LeaveRequest leaveRequest = new LeaveRequest(5, 5, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "denied");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        savedLeaveRequest.setStatus("Approved");
        LeaveRequest updatedLeaveRequest = leaveRequestRepository.save(savedLeaveRequest);

        Assertions.assertThat(updatedLeaveRequest.getStatus()).isEqualTo("Approved");
    }

    @Test
    public void testDeleteLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest(6,6,LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);

        leaveRequestRepository.deleteById(savedLeaveRequest.getId());

        Optional<LeaveRequest> foundLeaveRequest = leaveRequestRepository.findById(savedLeaveRequest.getId());

        Assertions.assertThat(foundLeaveRequest).isNotPresent();
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testApproveLeaveRequest() {
        LeaveRequest request = new LeaveRequest(1, 1, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");

        when(repository.findById(1)).thenReturn(Optional.of(request));

        service.approveLeaveRequest(1);

        assertThat(request.getStatus()).isEqualTo("Approved");
    }

    @Test
    public void testDenyLeaveRequest() {
        LeaveRequest request = new LeaveRequest(3, 3, LocalDate.now(), LocalDate.now().plusDays(10), "Vacation", "Pending");

        when(repository.findById(1)).thenReturn(Optional.of(request));

        service.denyLeaveRequest(1);

        assertThat(request.getStatus()).isEqualTo("Denied");
    }
}


