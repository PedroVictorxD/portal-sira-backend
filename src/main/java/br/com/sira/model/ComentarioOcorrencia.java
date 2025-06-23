package br.com.sira.model;

import java.time.LocalDateTime;

public class ComentarioOcorrencia {
    private Long id;
    private String texto;
    private LocalDateTime dataHora;
    private Usuario usuario;
    private Ocorrencia ocorrencia;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }
    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
} 