package br.com.fiap.dao;

import br.com.fiap.enums.TipoStatusServico;
import br.com.fiap.to.ServicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {

    public ArrayList<ServicoTO> findAll() {
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "select * from tb_servico order by id_servico";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoTO servico = new ServicoTO();
                    servico.setId(rs.getLong("id_servico"));
                    servico.setNome(rs.getString("nm_servico"));
                    servico.setDescricao(rs.getString("dc_servico"));

                    servicos.add(servico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar servico por ID");
        } finally {
            ConnectionFactory.closeConnection();
        }
        return servicos;
    }

    public ServicoTO findById(Long id) {
        ServicoTO servico = new ServicoTO();
        String sql = "select * from tb_servico where id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servico.setId(rs.getLong("id_servico"));
                servico.setNome(rs.getString("nm_servico"));
                servico.setDescricao(rs.getString("dc_servico"));
                servico.setStatusServico(TipoStatusServico.AGUARDANDO);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar servico por ID");
        } finally {
            ConnectionFactory.closeConnection();
        }
        return servico;
    }

    public ServicoTO save(ServicoTO servico) {
        String sql = "insert into tb_servico (id_servico, nm_servico, dc_servico, status_servico) values (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, servico.getId());
            ps.setString(2, servico.getNome());
            ps.setString(3, servico.getDescricao());
            ps.setString(4, servico.getStatusServico().toString());
            if (ps.executeUpdate() > 0) {
                return servico;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar servico por ID");
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(long id) {
        String sql = "delete from tb_servico where id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar servico por ID");
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ServicoTO update(ServicoTO servico) {
        String sql = "update tb_servico set nm_servico = ?, dc_servico = ?, status_servico = ? where id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getNome());
            ps.setString(2, servico.getDescricao());
            ps.setString(3, servico.getStatusServico().toString());
            if (ps.executeUpdate() > 0) {
                return servico;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar servico por ID");
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

}