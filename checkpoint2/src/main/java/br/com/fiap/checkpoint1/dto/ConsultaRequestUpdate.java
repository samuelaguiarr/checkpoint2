package br.com.fiap.checkpoint1.dto;

import java.time.LocalDateTime;

public class ConsultaRequestUpdate {
    private LocalDateTime dataConsulta;
    private String statusConsulta;
    private Double quantidadeHoras;
    private Double valorConsulta;

    // Getters e Setters
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
