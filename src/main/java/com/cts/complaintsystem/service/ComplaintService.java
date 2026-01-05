package com.cts.complaintsystem.service;

import com.cts.complaintsystem.model.Complaint;
import com.cts.complaintsystem.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public Complaint create(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepository.findByUserId(userId);
    }
}

