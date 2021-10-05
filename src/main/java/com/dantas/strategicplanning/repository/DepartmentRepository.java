package com.dantas.strategicplanning.repository;

import com.dantas.strategicplanning.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
