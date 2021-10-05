package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Department;
import com.dantas.strategicplanning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentResource {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> listAll(){
        return departmentRepository.findAll();
    }
}
