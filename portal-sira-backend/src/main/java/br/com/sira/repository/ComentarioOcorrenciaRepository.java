package br.com.sira.repository;

import br.com.sira.model.ComentarioOcorrencia;
import br.com.sira.model.Ocorrencia;
import br.com.sira.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ComentarioOcorrenciaRepository {

    @Autowired
    private DataSource dataSource;

    public List<ComentarioOcorrencia> listarPorOcorrencia(Long ocorrenciaId) {
        List<ComentarioOcorrencia> lista = new ArrayList<>();
        String sql = "SELECT c.id, c.texto, c.data_hora, c.nome_arquivo_anexo, u.id as usuario_id, u.username, u.nome FROM comentario_ocorrencia c JOIN usuario u ON c.usuario_id = u.id WHERE c.ocorrencia_id = ? ORDER BY c.data_hora ASC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, ocorrenciaId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComentarioOcorrencia c = new ComentarioOcorrencia();
                    c.setId(rs.getLong("id"));
                    c.setTexto(rs.getString("texto"));
                    c.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                    c.setNomeArquivoAnexo(rs.getString("nome_arquivo_anexo"));
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("usuario_id"));
                    u.setUsername(rs.getString("username"));
                    u.setNome(rs.getString("nome"));
                    c.setUsuario(u);
                    lista.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(ComentarioOcorrencia comentario) {
        String sql = "INSERT INTO comentario_ocorrencia (texto, data_hora, usuario_id, ocorrencia_id, nome_arquivo_anexo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comentario.getTexto());
            ps.setTimestamp(2, Timestamp.valueOf(comentario.getDataHora()));
            ps.setLong(3, comentario.getUsuario().getId());
            ps.setLong(4, comentario.getOcorrencia().getId());
            ps.setString(5, comentario.getNomeArquivoAnexo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 