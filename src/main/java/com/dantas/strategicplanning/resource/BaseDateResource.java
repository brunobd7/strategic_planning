package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.BaseDate;
import com.dantas.strategicplanning.repository.BaseDateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<BaseDate> findById(@PathVariable Long id){
        //TODO HANDLE CUSTOM MESSAGE USING messages.properties AND GLOBAL HANDLE EXCPTION COMPONENT
        //return baseDateRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BaseDate baseDateFounded = baseDateRepository.findById(id).orElse(null);
        return Objects.isNull(baseDateFounded)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(baseDateFounded);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBaseDateById(@PathVariable Long id){
        baseDateRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseDate> updateBaseDate(@Valid @RequestBody BaseDate baseDateUpdated , @PathVariable Long id ){

        BaseDate baseSaved = baseDateRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(baseDateUpdated,baseSaved,"id");

         baseSaved = baseDateRepository.save(baseSaved);

//         return ResponseEntity.status(HttpStatus.OK).body(baseSaved);
         return ResponseEntity.ok(baseSaved);
    }

}
