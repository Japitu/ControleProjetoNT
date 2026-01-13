package br.com.fiap.to;

import br.com.fiap.enums.TipoStatusServico;

import java.time.LocalDate;

public class ServicoTO {
    private long id;
    private String nome;
    private String descricao;
    private LocalDate horasGastas;
    private TipoStatusServico statusServico;

    public ServicoTO() {}

    public ServicoTO(long id, String nome, long idProjeto, String nomeProjeto, String descricao, LocalDate horasGastas, TipoStatusServico statusServico) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.horasGastas = horasGastas;
        this.statusServico = statusServico;
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

    public LocalDate getHorasGastas() {
        return horasGastas;
    }

    public void setHorasGastas(LocalDate horasGastas) {
        this.horasGastas = horasGastas;
    }

    public TipoStatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(TipoStatusServico statusServico) {
        this.statusServico = statusServico;
    }
}
