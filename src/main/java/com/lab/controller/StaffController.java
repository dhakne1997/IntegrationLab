package com.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lab.model.Staff;
import com.lab.service.StaffService;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public String listStaff(Model model) {
        List<Staff> staffList = staffService.findAll();
        model.addAttribute("staffList", staffList);
        return "staff/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "staff/form";
    }

    @PostMapping("/save")
    public String saveStaff(@ModelAttribute Staff staff) {
        staffService.save(staff);
        return "redirect:/staff";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Staff staff = staffService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staff);
        return "staff/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteById(id);
        return "redirect:/staff";
    }
}
