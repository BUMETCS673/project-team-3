package Employee_Management_System.LeaveRequest;

import lombok.Data;

@Data
public class ApprovalRejectionDto {
    //Approval id
    private int requestId;
    //Approval result[Approved/Pending/Rejection]
    private String status;


    public Integer getId() {
        return requestId;
    }

    public void setId(Integer id) {
        this.requestId = id;
    }

}