package com.qa.rest;

import com.qa.domain.Emperor;
import com.qa.dto.EmperorDTO;
import com.qa.service.EmperorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class EmperorController {

    private final EmperorService service;

    @Autowired
    public EmperorController(EmperorService service) {
        this.service = service;
    }

    @GetMapping("/getALlEmperors")
    public ResponseEntity<List<EmperorDTO>> getAllEmperors() {
        return ResponseEntity.ok(this.service.readEmperors());
    }

    @PostMapping("/createEmperor")
    public ResponseEntity<EmperorDTO> createEmperor(@RequestBody Emperor emp) {
        return new ResponseEntity<EmperorDTO>(this.service.createEmperor(emp), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmperor/{id}")
    public ResponseEntity<?> deleteEmperor(@PathVariable Long id) {
        return this.service.deleteEmperor(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();

    }

    @GetMapping("/getEmperorById/{id}")
    public ResponseEntity<EmperorDTO> getEmperorById(@PathVariable Long id) {
       return ResponseEntity.ok(this.service.findEmperorById(id));
    }

    @PutMapping("/updateEmperor/{id}")
    public ResponseEntity<EmperorDTO> updateEmperor(@PathVariable Long id, @RequestBody Emperor emp) {
        return ResponseEntity.ok(this.service.updateEmperor(id, emp));
    }

    @PutMapping("/updateEmperor2")
    public ResponseEntity<EmperorDTO> updateEmperor2(@PathParam("id") Long id, @RequestBody Emperor emp) {
        return ResponseEntity.ok(this.service.updateEmperor(id, emp));
    }
}
