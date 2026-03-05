package br.com.nt.to;

import br.com.nt.enums.TipoArea;
import br.com.nt.enums.TipoStatusServico;

import java.time.LocalTime;

public class ServicoTO {
    private long id;
    private String nome;
    private String numero;
    private TipoArea area;
    private TipoStatusServico statusServico;
    private ProjetoTO projeto;
    private UsuarioTO usuario;



    public ServicoTO() {}

    public ServicoTO(long id, String nome, ProjetoTO projeto, TipoArea area, TipoStatusServico statusServico, UsuarioTO usuario, String numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.projeto = projeto;
        this.area = area;
        this.statusServico = statusServico;
        this.usuario = usuario;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ProjetoTO getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoTO projeto) {
        this.projeto = projeto;
    }

    public TipoArea getArea() {
        return area;
    }

    public void setArea(TipoArea area) {
        this.area = area;
    }

    public TipoStatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(TipoStatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }
}
