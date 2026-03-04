package br.com.nt.to;

import com.aayushatharva.brotli4j.common.annotations.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AtividadeTO {

    private long id; // id_horas
    private String nome;
    private String descricao;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Duration tempoGasto;
    private UsuarioTO usuario;
    private ServicoTO servico;

    public AtividadeTO() {}

    public AtividadeTO(long id, String nome, String descricao, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Duration tempoGasto, UsuarioTO usuario, ServicoTO servico) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.tempoGasto = tempoGasto;
        this.usuario = usuario;
        this.servico = servico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public Duration getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(Duration tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public ServicoTO getServico() {
        return servico;
    }

    public void setServico(ServicoTO servico) {
        this.servico = servico;
    }
}
