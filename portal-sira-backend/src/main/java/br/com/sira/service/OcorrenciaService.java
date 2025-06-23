package br.com.sira.service;

import br.com.sira.model.Ocorrencia;
import br.com.sira.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> listarTodas() {
        return ocorrenciaRepository.listarTodas();
    }

    public void inserir(Ocorrencia ocorrencia) {
        ocorrenciaRepository.inserir(ocorrencia);
    }

    public Ocorrencia buscarPorId(Long id) {
        return ocorrenciaRepository.buscarPorId(id);
    }

    public void atualizar(Ocorrencia ocorrencia) {
        ocorrenciaRepository.atualizar(ocorrencia);
    }

    public void excluir(Long id) {
        ocorrenciaRepository.excluir(id);
    }
} 