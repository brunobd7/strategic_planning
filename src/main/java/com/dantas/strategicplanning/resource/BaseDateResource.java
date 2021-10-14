package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.BaseDate;
import com.dantas.strategicplanning.repository.BaseDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/base_dates")
public class BaseDateResource {

    @Autowired
    BaseDateRepository baseDateRepository;

    @GetMapping
    public List<BaseDate> listAll(){
        return baseDateRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<BaseDate> createBaseDate(@Valid @RequestBody BaseDate baseDate, HttpServletResponse response){

        BaseDate baseDateCreated = baseDateRepository.save(baseDate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(baseDateCreated.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(baseDateCreated);
    }

    @GetMapping("/{id}")
    public BaseDate findById(@PathVariable Long id){
        return baseDateRepository.findById(id).orElse(new BaseDate());
    }

}
