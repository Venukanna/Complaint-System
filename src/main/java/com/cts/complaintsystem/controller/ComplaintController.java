package com.cts.complaintsystem.controller;




import com.cts.complaintsystem.dto.ComplaintRequest;
import com.cts.complaintsystem.model.Complaint;
import com.cts.complaintsystem.model.User;
import com.cts.complaintsystem.service.ComplaintService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
@CrossOrigin
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping("/create")
    public Complaint create(@RequestBody ComplaintRequest req){
        User user = new User();
        user.setId(req.getUserId());

        Complaint c = new Complaint();
        c.setTitle(req.getTitle());
        c.setCategory(req.getCategory());
        c.setDescription(req.getDescription());
        c.setUser(user);

        return complaintService.create(c);
    }

    @GetMapping("/user/{id}")
    public List<Complaint> getUserComplaints(@PathVariable Long id){
        return complaintService.getUserComplaints(id);
    }

    @GetMapping("/all")
    public List<Complaint> getAllComplaints(){
        return complaintService.getAllComplaints();
    }
}
