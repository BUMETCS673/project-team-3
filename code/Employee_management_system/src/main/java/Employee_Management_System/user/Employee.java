package Employee_Management_System.user;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "employees_info")
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "annualSalary")
    private Double annualSalary;


    // constructor
    public Employee(String id,
                    String name,
                    String email,
                    String phoneNumber,
                    String jobTitle,
                    Double annualSalary
                    ) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.annualSalary = annualSalary;

    }


    public Employee() {
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", name=" + name +
                ", jobTitle='" + jobTitle + '\'' +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
