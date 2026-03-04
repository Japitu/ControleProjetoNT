package br.com.nt.bo;

import br.com.nt.dao.AtividadeDAO;
import br.com.nt.dao.ServicoDAO;
import br.com.nt.dao.UsuarioDAO;
import br.com.nt.to.AtividadeTO;
import br.com.nt.to.ServicoTO;
import br.com.nt.to.UsuarioTO;

import java.util.ArrayList;

public class AtividadeBO {
    private AtividadeDAO atividadeDAO;
    private UsuarioDAO usuarioDAO;
    private ServicoDAO servicoDAO;

    public ArrayList<AtividadeTO> findAll() {
        atividadeDAO = new AtividadeDAO();

        return atividadeDAO.findAll();
    }

    public AtividadeTO findById(long id) {
        atividadeDAO = new AtividadeDAO();

        return atividadeDAO.findById(id);
    }

    public ArrayList<AtividadeTO> findByServico(long id) {
        atividadeDAO = new AtividadeDAO();

        return atividadeDAO.findByServico(id);
    }

    public AtividadeTO save(AtividadeTO atividade) throws Exception {
        atividadeDAO = new AtividadeDAO();
        usuarioDAO = new UsuarioDAO();
        servicoDAO = new  ServicoDAO();

        UsuarioTO atividadeUsuario = usuarioDAO.findById(atividade.getUsuario().getId());
        if (atividadeUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        ServicoTO atividadeServico = servicoDAO.findById(atividade.getServico().getId());
        if (atividadeServico == null) {
            throw new Exception("Não existe um servico com o id informado");
        }

        atividade.setUsuario(atividadeUsuario);
        atividade.setServico(atividadeServico);

        return atividadeDAO.save(atividade);
    }

    public boolean delete(long id) {
        atividadeDAO = new AtividadeDAO();

        return atividadeDAO.delete(id);
    }

    public AtividadeTO update(AtividadeTO atividade) throws Exception {
        atividadeDAO = new AtividadeDAO();
        usuarioDAO = new UsuarioDAO();
        servicoDAO = new  ServicoDAO();

        UsuarioTO atividadeUsuario = usuarioDAO.findById(atividade.getUsuario().getId());
        if (atividadeUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        ServicoTO atividadeServico = servicoDAO.findById(atividade.getServico().getId());
        if (atividadeServico == null) {
            throw new Exception("Não existe um servico com o id informado");
        }

        atividade.setUsuario(atividadeUsuario);
        atividade.setServico(atividadeServico);

        return atividadeDAO.update(atividade);
    }
}
