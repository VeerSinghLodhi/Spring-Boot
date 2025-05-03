package com.Assignment.Assignment.EAssignment;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="enquiries")
public class EnquiryMaster {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="enquiry_id")
    int enquiryid;
    String name,phone,subject,message,status;
    LocalDate enquiry_date;

    public EnquiryMaster() {
    }

    public EnquiryMaster(String status, int enquiryid, String name, String phone, String subject, String message, LocalDate enquiry_date) {
        this.status = status;
        this.enquiryid = enquiryid;
        this.name = name;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.enquiry_date = enquiry_date;
    }

    public int getEnquiryid() {
        return enquiryid;
    }

    public void setEnquiryid(int enquiryid) {
        this.enquiryid = enquiryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getEnquiry_date() {
        return enquiry_date;
    }

    public void setEnquiry_date(LocalDate enquiry_date) {
        this.enquiry_date = enquiry_date;
    }
}
