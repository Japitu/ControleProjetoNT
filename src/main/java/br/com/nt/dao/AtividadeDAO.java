package br.com.nt.dao;

import br.com.nt.to.AtividadeTO;
import br.com.nt.to.ServicoTO;
import br.com.nt.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;

public class AtividadeDAO {

    public ArrayList<AtividadeTO> findAll() {
        ArrayList<AtividadeTO> atividades = new ArrayList<AtividadeTO>();
        String sql = "select a.*, u.nm_usuario, EXTRACT(EPOCH FROM (a.hr_fim_atividade - a.hr_inicio_atividade)) AS tempo_segundos from tb_atividade a inner join tb_usuario u on a.id_usuario = u.id_usuario inner join tb_servico s on a.id_servico = s.id_servico order by a.id_horas ASC";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AtividadeTO atividade = new AtividadeTO();
                    UsuarioTO usuario = new UsuarioTO();
                    ServicoTO servico = new ServicoTO();

                    atividade.setId(rs.getLong("id_atividade"));
                    atividade.setNome(rs.getString("nm_atividade"));
                    atividade.setDescricao(rs.getString("dc_atividade"));
                    atividade.setData(rs.getDate("dt_atividade").toLocalDate());
                    atividade.setHoraInicio(rs.getTime("hr_inicio_atividade").toLocalTime());
                    atividade.setHoraFim(rs.getTime("hr_fim_atividade").toLocalTime());

                    atividade.setTempoGasto(Duration.ofSeconds(rs.getLong("tempo_segundos")));

                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    atividade.setUsuario(usuario);

                    servico.setId(rs.getLong("id_servico"));
                    atividade.setServico(servico);

                    atividades.add(atividade);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return atividades;
    }

    public AtividadeTO findById(Long id) {
        AtividadeTO atividade = new AtividadeTO();
        UsuarioTO usuario = new UsuarioTO();
        ServicoTO servico = new ServicoTO();
        String sql = "select a.*, u.nm_usuario, EXTRACT(EPOCH FROM (a.hr_fim_atividade - a.hr_inicio_atividade)) AS tempo_segundos from tb_atividade a inner join tb_usuario u on a.id_usuario = u.id_usuario inner join tb_servico s on a.id_servico = s.id_servico where a.id_horas = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                atividade.setId(rs.getLong("id_atividade"));
                atividade.setNome(rs.getString("nm_atividade"));
                atividade.setDescricao(rs.getString("dc_atividade"));
                atividade.setData(rs.getDate("dt_atividade").toLocalDate());
                atividade.setHoraInicio(rs.getTime("hr_inicio_atividade").toLocalTime());
                atividade.setHoraFim(rs.getTime("hr_fim_atividade").toLocalTime());

                atividade.setTempoGasto(Duration.ofSeconds(rs.getLong("tempo_segundos")));

                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                atividade.setUsuario(usuario);

                servico.setId(rs.getLong("id_servico"));
                atividade.setServico(servico);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return atividade;
    }

    public ArrayList<AtividadeTO> findByServico(Long id) {
        ArrayList<AtividadeTO> atividades = new ArrayList<AtividadeTO>();

        String sql = "select a.*, u.nm_usuario, EXTRACT(EPOCH FROM (a.hr_fim_atividade - a.hr_inicio_atividade)) AS tempo_segundos from tb_atividade a inner join tb_usuario u on a.id_usuario = u.id_usuario inner join tb_servico s on a.id_servico = s.id_servico where a.id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    AtividadeTO atividade = new AtividadeTO();
                    UsuarioTO usuario = new UsuarioTO();
                    ServicoTO servico = new ServicoTO();

                    atividade.setId(rs.getLong("id_atividade"));
                    atividade.setNome(rs.getString("nm_atividade"));
                    atividade.setDescricao(rs.getString("dc_atividade"));
                    atividade.setData(rs.getDate("dt_atividade").toLocalDate());
                    atividade.setHoraInicio(rs.getTime("hr_inicio_atividade").toLocalTime());
                    atividade.setHoraFim(rs.getTime("hr_fim_atividade").toLocalTime());

                    atividade.setTempoGasto(Duration.ofSeconds(rs.getLong("tempo_segundos")));

                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    atividade.setUsuario(usuario);

                    servico.setId(rs.getLong("id_servico"));
                    atividade.setServico(servico);

                    atividades.add(atividade);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return atividades;
    }

    public AtividadeTO save(AtividadeTO atividade) {
        String sql = "insert into tb_atividade (nm_atividade, dc_atividade, dt_atividade, hr_inicio_atividade, hr_fim_atividade, id_usuario, id_servico) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, atividade.getNome());
            ps.setString(2, atividade.getDescricao());
            ps.setString(3, atividade.getData().toString());
            ps.setString(4, atividade.getHoraInicio().toString());
            ps.setString(5, atividade.getHoraFim().toString());
            ps.setLong(6, atividade.getUsuario().getId());
            ps.setLong(7, atividade.getServico().getId());
            if (ps.executeUpdate() > 0) {
                return atividade;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from tb_atividade where id_atividade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public AtividadeTO update(AtividadeTO atividade) {
        String sql = "update tb_atividade set nm_atividade = ?, dc_atividade = ?, dt_atividade = ?, hr_inicio_atividade = ?, hr_fim_atividade = ?, id_usuario = ?, id_servico = ? where id_atividade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, atividade.getNome());
            ps.setString(2, atividade.getDescricao());
            ps.setString(3, atividade.getData().toString());
            ps.setString(4, atividade.getHoraInicio().toString());
            ps.setString(5, atividade.getHoraFim().toString());
            ps.setLong(6, atividade.getUsuario().getId());
            ps.setLong(7, atividade.getServico().getId());
            ps.setLong(8, atividade.getId());
            if (ps.executeUpdate() > 0) {
                return atividade;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
