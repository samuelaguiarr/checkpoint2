package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint1.dto.ProfissionalResponse;
import br.com.fiap.checkpoint1.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponse> create(@RequestBody ProfissionalRequestCreate dto) {
        return ResponseEntity.status(201).body(
            new ProfissionalResponse().toDto(profissionalService.createProfissional(dto))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> update(@PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto) {
        return profissionalService.updateProfissional(id, dto)
            .map(p -> new ProfissionalResponse().toDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = profissionalService.deleteProfissional(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> findById(@PathVariable Long id) {
        return profissionalService.getProfissionalById(id)
            .map(p -> new ProfissionalResponse().toDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> findAll() {
        List<ProfissionalResponse> response = profissionalService.getAll().stream()
            .map(p -> new ProfissionalResponse().toDto(p))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
