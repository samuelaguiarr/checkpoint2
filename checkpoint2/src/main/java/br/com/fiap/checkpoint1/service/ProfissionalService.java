package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint1.model.Profissional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {
    private List<Profissional> profissionais = new ArrayList<>();
    private Long sequence = 1L;

    public Profissional createProfissional(ProfissionalRequestCreate dto) {
        Profissional profissional = new Profissional();
        profissional.setId(sequence++);
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());
        profissional.setCreatedAt(LocalDateTime.now());
        profissional.setUpdatedAt(LocalDateTime.now());
        profissionais.add(profissional);
        return profissional;
    }

    public Optional<Profissional> getProfissionalById(Long id) {
        return profissionais.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    public List<Profissional> getAll() {
        return profissionais;
    }

    public Optional<Profissional> updateProfissional(Long id, ProfissionalRequestUpdate dto) {
        return profissionais.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> {
                p.setNome(dto.getNome());
                p.setEspecialidade(dto.getEspecialidade());
                p.setValorHora(dto.getValorHora());
                p.setUpdatedAt(LocalDateTime.now());
                return p;
            });
    }

    public boolean deleteProfissional(Long id) {
        return profissionais.removeIf(p -> p.getId().equals(id));
    }
}
