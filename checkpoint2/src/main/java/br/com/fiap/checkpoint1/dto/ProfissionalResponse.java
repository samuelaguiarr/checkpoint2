package br.com.fiap.checkpoint1.dto;

import br.com.fiap.checkpoint1.model.Profissional;

public class ProfissionalResponse {
    private Long id;
    private String nome;
    private String especialidade;
    private Double valorHora;

    public ProfissionalResponse toDto(Profissional profissional) {
        this.setId(profissional.getId());
        this.setNome(profissional.getNome());
        this.setEspecialidade(profissional.getEspecialidade());
        this.setValorHora(profissional.getValorHora());
        return this;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public Double getValorHora() {
        return valorHora;
    }
    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
}
