package br.com.nt.bo;

import br.com.nt.dao.ClienteDAO;
import br.com.nt.dao.ProjetoDAO;
import br.com.nt.to.ClienteTO;
import br.com.nt.to.ProjetoTO;

import java.util.ArrayList;

public class ProjetoBO {
    private ProjetoDAO projetoDAO;
    private ClienteDAO clienteDAO;

    public ArrayList<ProjetoTO> findAll() {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.findAll();
    }

    public ProjetoTO findById(Long id) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.findById(id);
    }

    public ProjetoTO save (ProjetoTO projeto) throws Exception {
        projetoDAO = new ProjetoDAO();
        clienteDAO = new ClienteDAO();

        ClienteTO projetoCliente = clienteDAO.findById(projeto.getCliente().getId());
        if (projetoCliente == null) {
            throw new Exception("Não existe um cliente com o id informado");
        }

        projeto.setCliente(projetoCliente);

        return projetoDAO.save(projeto);
    }

    public boolean delete (Long id) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.delete(id);
    }

    public ProjetoTO update(ProjetoTO projeto) throws Exception {
        projetoDAO = new ProjetoDAO();
        clienteDAO = new ClienteDAO();

        ClienteTO projetoCliente = clienteDAO.findById(projeto.getCliente().getId());
        if (projetoCliente == null) {
            throw new Exception("Não existe um cliente com o id informado");
        }

        projeto.setCliente(projetoCliente);

        return projetoDAO.update(projeto);
    }
}
