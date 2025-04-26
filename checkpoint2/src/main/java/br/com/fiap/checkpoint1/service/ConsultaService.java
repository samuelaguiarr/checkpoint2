package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.ConsultaRequestCreate;
import br.com.fiap.checkpoint1.dto.ConsultaRequestUpdate;
import br.com.fiap.checkpoint1.model.Consulta;
import br.com.fiap.checkpoint1.model.Profissional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private List<Consulta> consultas = new ArrayList<>();
    private Long sequence = 1L;

    @Autowired
    private ProfissionalService profissionalService;

    public Consulta createConsulta(ConsultaRequestCreate dto) {
        Consulta consulta = new Consulta();
        consulta.setId(sequence++);
        consulta.setProfissionalId(dto.getProfissionalId());
        consulta.setPacienteId(dto.getPacienteId());
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());

        // Busca o profissional para pegar o valorHora
        Optional<Profissional> profissionalOpt = profissionalService.getProfissionalById(dto.getProfissionalId());
        if (profissionalOpt.isPresent()) {
            Double valorHora = profissionalOpt.get().getValorHora();
            Double valorConsulta = valorHora * dto.getQuantidadeHoras();
            consulta.setValorConsulta(valorConsulta);
        } else {
            consulta.setValorConsulta(0.0); // Se não encontrar profissional, coloca 0
        }

        consulta.setCreatedAt(LocalDateTime.now());
        consulta.setUpdatedAt(LocalDateTime.now());
        consultas.add(consulta);
        return consulta;
    }

    public Optional<Consulta> getConsultaById(Long id) {
        return consultas.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();
    }

    public List<Consulta> getAll() {
        return consultas;
    }

    public Optional<Consulta> updateConsulta(Long id, ConsultaRequestUpdate dto) {
        return consultas.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .map(c -> {
                c.setDataConsulta(dto.getDataConsulta());
                c.setStatusConsulta(dto.getStatusConsulta());
                c.setQuantidadeHoras(dto.getQuantidadeHoras());

                // Atualiza também o valorConsulta com base no valorHora atualizado
                Optional<Profissional> profissionalOpt = profissionalService.getProfissionalById(c.getProfissionalId());
                if (profissionalOpt.isPresent()) {
                    Double valorHora = profissionalOpt.get().getValorHora();
                    Double valorConsulta = valorHora * dto.getQuantidadeHoras();
                    c.setValorConsulta(valorConsulta);
                }

                c.setUpdatedAt(LocalDateTime.now());
                return c;
            });
    }

    public boolean deleteConsulta(Long id) {
        return consultas.removeIf(c -> c.getId().equals(id));
    }
}
