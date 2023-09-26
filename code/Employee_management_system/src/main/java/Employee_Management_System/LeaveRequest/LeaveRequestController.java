
package Employee_Management_System.LeaveRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/create-leave-request")
    public void createLeaveRequest(@ModelAttribute LeaveRequest leaveRequest) {
        leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @PutMapping("/update-leave-request")
    public void updateLeaveRequest(@ModelAttribute LeaveRequest leaveRequest) {
        leaveRequestService.updateLeaveRequest(leaveRequest);
    }

    @GetMapping("/leave-request/{id}")
    public LeaveRequest getLeaveRequestByID(@PathVariable int id) {
        return leaveRequestService.getLeaveRequestByID(id);
    }

    @GetMapping("/list-all-leave-requests")
    public List<LeaveRequest> listAllLeaveRequests() {
        return leaveRequestService.listAllLeaveRequests();
    }

    @DeleteMapping("/delete-leave-request/{id}")
    public void deleteLeaveRequest(@PathVariable int id) {
        leaveRequestService.deleteLeaveRequest(id);
    }
}
