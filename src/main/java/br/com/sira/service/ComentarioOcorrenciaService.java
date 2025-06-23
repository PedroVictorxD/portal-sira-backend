package br.com.sira.service;

import br.com.sira.model.ComentarioOcorrencia;
import br.com.sira.repository.ComentarioOcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioOcorrenciaService {

    @Autowired
    private ComentarioOcorrenciaRepository comentarioOcorrenciaRepository;

    public List<ComentarioOcorrencia> listarPorOcorrencia(Long ocorrenciaId) {
        return comentarioOcorrenciaRepository.listarPorOcorrencia(ocorrenciaId);
    }

    public void inserir(ComentarioOcorrencia comentario) {
        comentarioOcorrenciaRepository.inserir(comentario);
    }
} 