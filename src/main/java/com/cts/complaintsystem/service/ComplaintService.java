//package com.cts.complaintsystem.service;
//
//import com.cts.complaintsystem.model.Complaint;
//import com.cts.complaintsystem.repository.ComplaintRepository;
//import org.springframework.stereotype.Service;
//
//import lombok.RequiredArgsConstructor;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ComplaintService {
//
//    private final ComplaintRepository complaintRepository;
//
//    public Complaint create(Complaint complaint) {
//        return complaintRepository.save(complaint);
//    }
//
//    public List<Complaint> getUserComplaints(Long userId) {
//        return complaintRepository.findByUserId(userId);
//    }
//}
//


package com.cts.complaintsystem.service;

import com.cts.complaintsystem.model.Complaint;
import com.cts.complaintsystem.repository.ComplaintRepository;
import com.cts.complaintsystem.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;   // 👈 added

    public Complaint create(Complaint complaint) {

        Long userId = complaint.getUser().getId();

        // 🔐 Validation
        if (!userRepository.existsById(userId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "User ID not valid"
            );
        }

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepository.findByUserId(userId);

    }
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}
