package com.esprit.reglements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/reglements")

public class ReglementController {

    @Autowired
    private ReglementService reglementService;

    @GetMapping
    public List<Reglement> getAll() {
        return reglementService.getAll();
    }

    @PostMapping
    public Reglement save(@RequestBody Reglement reglement) {
        return reglementService.save(reglement);
    }

    @GetMapping("/facture/{factureId}")
    public List<Reglement> byFacture(@PathVariable Long factureId) {
        return reglementService.findByFactureId(factureId);
    }


}
