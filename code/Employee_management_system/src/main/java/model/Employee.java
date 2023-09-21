package model;

import jakarta.persistence.*;

@Entity
@Table
public class Employee {

    @Id
//    @SequenceGenerator(
//            name = "employee_sequence",
//            sequenceName = "employee_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "employee_sequence"
//    )
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private Double annualSalary;

    // constructor
    public Employee(Integer id,
                    String name,
                    String email,
                    String phoneNumber,
                    String jobTitle,
                    Double annualSalary) {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
