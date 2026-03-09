package br.com.nt.to;

import br.com.nt.enums.TipoArea;
import br.com.nt.enums.TipoServico;
import br.com.nt.enums.TipoStatusServico;

import java.time.LocalTime;

public class ServicoTO {
    private long id;
    private String nome;
    private String numero;
    private TipoArea area;
    private TipoServico tipo;
    private TipoStatusServico status;
    private boolean arquivado;
    private ProjetoTO projeto;
    private UsuarioTO usuario;


    public ServicoTO() {}

    public ServicoTO(long id, String nome, ProjetoTO projeto, TipoArea area, TipoServico tipo, TipoStatusServico status, boolean arquivado, UsuarioTO usuario, String numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.area = area;
        this.tipo = tipo;
        this.status = status;
        this.arquivado = arquivado;
        this.usuario = usuario;
        this.projeto = projeto;
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

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    public TipoStatusServico getStatus() {
        return status;
    }

    public void setStatus(TipoStatusServico status) {
        this.status = status;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }
}
