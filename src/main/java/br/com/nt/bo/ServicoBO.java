package br.com.nt.bo;

import br.com.nt.dao.ProjetoDAO;
import br.com.nt.dao.ServicoDAO;
import br.com.nt.dao.UsuarioDAO;
import br.com.nt.to.ProjetoTO;
import br.com.nt.to.ServicoTO;
import br.com.nt.to.UsuarioTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO;
    private ProjetoDAO projetoDAO;
    private UsuarioDAO usuarioDAO;

    public ArrayList<ServicoTO> findAll() {
        servicoDAO = new ServicoDAO();

        return servicoDAO.findAll();
    }

    public ServicoTO findById(long id) {
        servicoDAO = new ServicoDAO();

        return servicoDAO.findById(id);
    }

    public ServicoTO save(ServicoTO servico) throws Exception {
        servicoDAO = new ServicoDAO();
        projetoDAO = new ProjetoDAO();
        usuarioDAO = new UsuarioDAO();

        ProjetoTO servicoProjeto = projetoDAO.findById(servico.getProjeto().getId());
        if(servicoProjeto == null) {
            throw new Exception("Não existe um projeto com o id informado");
        }

        UsuarioTO servicoUsuario = usuarioDAO.findById(servico.getUsuario().getId());
        if(servicoUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        servico.setProjeto(servicoProjeto);
        servico.setUsuario(servicoUsuario);

        return servicoDAO.save(servico);
    }

    public boolean delete(long id) {
        servicoDAO = new ServicoDAO();

        if(servicoDAO.findById(id) == null) {
            return false;
        }

        return servicoDAO.delete(id);
    }

    public ServicoTO update(ServicoTO servico) throws Exception {
        servicoDAO = new ServicoDAO();
        projetoDAO = new ProjetoDAO();
        usuarioDAO = new UsuarioDAO();

        ProjetoTO servicoProjeto = projetoDAO.findById(servico.getProjeto().getId());
        if(servicoProjeto == null) {
            throw new Exception("Não existe um projeto com o id informado");
        }

        UsuarioTO servicoUsuario = usuarioDAO.findById(servico.getUsuario().getId());
        if(servicoUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        servico.setProjeto(servicoProjeto);
        servico.setUsuario(servicoUsuario);

        return servicoDAO.update(servico);
    }
}
