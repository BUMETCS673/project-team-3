package Employee_Management_System.LeaveRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public void createLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequestRepository.save(leaveRequest);
    }

    public void updateLeaveRequest(LeaveRequest leaveRequest) {
        if(leaveRequestRepository.existsById(leaveRequest.getId())) {
            leaveRequestRepository.save(leaveRequest);
        }
    }

    public LeaveRequest getLeaveRequestByID(int id) {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(id);
        return optionalLeaveRequest.orElse(null);
    }

    public List<LeaveRequest> listAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public void deleteLeaveRequest(int id) {
        leaveRequestRepository.deleteById(id);
    }

    // In LeaveRequestService class:

    public void approveLeaveRequest(int id) {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(id);
        if (optionalLeaveRequest.isPresent()) {
            LeaveRequest leaveRequest = optionalLeaveRequest.get();
            leaveRequest.setStatus("Approved");
            leaveRequestRepository.save(leaveRequest);
        }
    }

    public void denyLeaveRequest(int id) {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(id);
        if (optionalLeaveRequest.isPresent()) {
            LeaveRequest leaveRequest = optionalLeaveRequest.get();
            leaveRequest.setStatus("Denied");
            leaveRequestRepository.save(leaveRequest);
        }
    }

//

}
