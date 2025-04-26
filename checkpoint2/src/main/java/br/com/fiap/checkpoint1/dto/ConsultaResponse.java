package br.com.fiap.checkpoint1.dto;

import br.com.fiap.checkpoint1.model.Consulta;
import java.time.LocalDateTime;

public class ConsultaResponse {
    private Long id;
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime dataConsulta;
    private String statusConsulta;
    private Double quantidadeHoras;
    private Double valorConsulta;

    public ConsultaResponse toDto(Consulta consulta) {
        this.setId(consulta.getId());
        this.setProfissionalId(consulta.getProfissionalId());
        this.setPacienteId(consulta.getPacienteId());
        this.setDataConsulta(consulta.getDataConsulta());
        this.setStatusConsulta(consulta.getStatusConsulta());
        this.setQuantidadeHoras(consulta.getQuantidadeHoras());
        this.setValorConsulta(consulta.getValorConsulta());
        return this;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProfissionalId() {
        return profissionalId;
    }
    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }
    public Long getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getStatusConsulta() {
        return statusConsulta;
    }
    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }
    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }
    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
    public Double getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
