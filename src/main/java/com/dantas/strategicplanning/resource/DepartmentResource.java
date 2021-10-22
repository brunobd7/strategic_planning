package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.Department;
import com.dantas.strategicplanning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/departments")
public class DepartmentResource {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> listAll(){
        return departmentRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department){

        //todo refactor to return location into response header using httpServletResponse.
        Department createdDepartment = departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long id){

        Department departmentFounded = departmentRepository.findById(id).orElse(null);

        return Objects.isNull(departmentFounded)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(departmentFounded);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartmentById(@PathVariable Long id){
        departmentRepository.deleteById(id);
    }
}
