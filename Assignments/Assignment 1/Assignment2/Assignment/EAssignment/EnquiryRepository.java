package com.Assignment.Assignment.EAssignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryRepository extends JpaRepository<EnquiryMaster,Integer> {

    List<EnquiryMaster>findByEnquiryidOrNameContainingIgnoreCaseOrStatus(int enquiryid,String name,String status);
    List<EnquiryMaster>findByEnquiryid(int enquiryid);
}
