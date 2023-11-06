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


    public void approvalRejections(ApprovalRejectionDto approvalRejectionDto) {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(approvalRejectionDto.getRequestId());
        if (optionalLeaveRequest.isPresent()) {
            LeaveRequest leaveRequest = optionalLeaveRequest.get();
            leaveRequest.setStatus(approvalRejectionDto.getStatus());
            leaveRequestRepository.saveAndFlush(leaveRequest);
        }
    }


}
