package br.com.sira.repository;

import br.com.sira.model.Chamado;
import br.com.sira.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ChamadoRepository {

    @Autowired
    private DataSource dataSource;

    public List<Chamado> listarTodos() {
        List<Chamado> lista = new ArrayList<>();
        String sql = "SELECT c.id, c.titulo, c.descricao, c.data_hora_abertura, c.status, c.destinatario, c.tipo, u.id as usuario_id, u.username, u.nome FROM chamado c JOIN usuario u ON c.usuario_abertura_id = u.id ORDER BY c.data_hora_abertura DESC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Chamado c = new Chamado();
                c.setId(rs.getLong("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDescricao(rs.getString("descricao"));
                c.setDataHoraAbertura(rs.getTimestamp("data_hora_abertura").toLocalDateTime());
                c.setStatus(rs.getString("status"));
                c.setDestinatario(rs.getString("destinatario"));
                c.setTipo(rs.getString("tipo"));
                Usuario u = new Usuario();
                u.setId(rs.getLong("usuario_id"));
                u.setUsername(rs.getString("username"));
                u.setNome(rs.getString("nome"));
                c.setUsuarioAbertura(u);
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Chamado chamado) {
        String sql = "INSERT INTO chamado (titulo, descricao, data_hora_abertura, status, usuario_abertura_id, destinatario, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, chamado.getTitulo());
            ps.setString(2, chamado.getDescricao());
            ps.setTimestamp(3, Timestamp.valueOf(chamado.getDataHoraAbertura()));
            ps.setString(4, chamado.getStatus());
            ps.setLong(5, chamado.getUsuarioAbertura().getId());
            ps.setString(6, chamado.getDestinatario());
            ps.setString(7, chamado.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 