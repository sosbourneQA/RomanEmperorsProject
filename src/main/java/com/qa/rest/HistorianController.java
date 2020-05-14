//package com.qa.rest;
//
//
//import com.qa.domain.Historian;
//import com.qa.dto.HistorianDTO;
//import com.qa.service.HistorianService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.websocket.server.PathParam;
//import java.util.List;
//
//@Controller
//public class HistorianController {
////
////    private final HistorianService service;
////
////    @Autowired
////    public HistorianController(HistorianService service) {
////        this.service = service;
////    }
////
////    @GetMapping("/getAllHistorians")
////    public ResponseEntity<List<HistorianDTO>> getAllHistorians() {
////        return ResponseEntity.ok(this.service.readHistorians());
////    }
////
////    @PostMapping("/createHistorian")
////    public ResponseEntity<HistorianDTO> createEmperor(@RequestBody Historian hist) {
////        return new ResponseEntity<HistorianDTO>(this.service.createHistorian(hist), HttpStatus.CREATED);
////    }
////
////    @DeleteMapping("/deleteHistorian/{id}")
////    public ResponseEntity<?> deleteEmperor(@PathVariable Long id) {
////        return this.service.deleteHistorian(id)
////                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
////                : ResponseEntity.noContent().build();
////
////    }
////
////    @GetMapping("/getHistorianById/{id}")
////    public ResponseEntity<HistorianDTO> getEmperorById(@PathVariable Long id) {
////        return ResponseEntity.ok(this.service.findHistorianById(id));
////    }
////
////    @PutMapping("/updateHistorian/{id}")
////    public ResponseEntity<HistorianDTO> updateHistorian(@PathVariable Long id, @RequestBody Historian hist) {
////        return ResponseEntity.ok(this.service.updateHistorian(id, hist));
////    }
////
////    @PutMapping("/updateHistorian2")
////    public ResponseEntity<HistorianDTO> updateHistorian2(@PathParam("id") Long id, @RequestBody Historian hist) {
////        return ResponseEntity.ok(this.service.updateHistorian(id, hist));
////    }
//}