package com.example.employee_management.repo;

import com.example.employee_management.Entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
