package br.com.sira.repository;

import br.com.sira.model.Ocorrencia;
import br.com.sira.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OcorrenciaRepository {

    @Autowired
    private DataSource dataSource;

    public List<Ocorrencia> listarTodas() {
        List<Ocorrencia> lista = new ArrayList<>();
        String sql = "SELECT o.id, o.titulo, o.descricao, o.data_hora, u.id as usuario_id, u.username, u.nome FROM ocorrencia o JOIN usuario u ON o.usuario_id = u.id ORDER BY o.data_hora DESC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setId(rs.getLong("id"));
                o.setTitulo(rs.getString("titulo"));
                o.setDescricao(rs.getString("descricao"));
                o.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                Usuario u = new Usuario();
                u.setId(rs.getLong("usuario_id"));
                u.setUsername(rs.getString("username"));
                u.setNome(rs.getString("nome"));
                o.setUsuario(u);
                lista.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Ocorrencia ocorrencia) {
        String sql = "INSERT INTO ocorrencia (titulo, descricao, data_hora, usuario_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ocorrencia.getTitulo());
            ps.setString(2, ocorrencia.getDescricao());
            ps.setTimestamp(3, Timestamp.valueOf(ocorrencia.getDataHora()));
            ps.setLong(4, ocorrencia.getUsuario().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 