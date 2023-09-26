package Employee_Management_System.LeaveRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {

    @Id
    private int requestID;
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String status;



    public LeaveRequest(int requestID, int employeeId,LocalDate startDate, LocalDate endDate, String leaveType, String status) {
        this.requestID = requestID;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
    }

    public LeaveRequest() {

    }

    public Integer getId() {
        return requestID;
    }

    public void setId(Integer id) {
        this.requestID = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return leaveType;
    }

    public void setReason(String reason) {
        this.leaveType = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VacationRequest{" +
                "id=" + requestID +
                ", employeeId=" + employeeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reason='" + leaveType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    // Getters and Setters for all attributes...
}