package com.lab.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
