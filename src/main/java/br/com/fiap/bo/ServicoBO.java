package br.com.fiap.bo;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ServicoTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO = new ServicoDAO();

    public ArrayList<ServicoTO> findAll() {
        servicoDAO = new ServicoDAO();

        return servicoDAO.findAll();
    }

    public ServicoTO findById(long id) {
        servicoDAO = new ServicoDAO();

        return servicoDAO.findById(id);
    }

    public ServicoTO save(ServicoTO servico) {
        servicoDAO = new ServicoDAO();

        return servicoDAO.save(servico);
    }

    public boolean delete(long id) {
        servicoDAO = new ServicoDAO();

        return servicoDAO.delete(id);
    }

    public ServicoTO update(ServicoTO servico) {
        servicoDAO = new ServicoDAO();

        return servicoDAO.update(servico);
    }
}
