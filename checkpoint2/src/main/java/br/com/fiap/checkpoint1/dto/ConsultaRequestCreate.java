package br.com.fiap.checkpoint1.dto;

import java.time.LocalDateTime;

public class ConsultaRequestCreate {
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime dataConsulta;
    private String statusConsulta;
    private Double quantidadeHoras;

    // Getters e Setters
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
}
