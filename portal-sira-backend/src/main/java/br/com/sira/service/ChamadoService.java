package br.com.sira.service;

import br.com.sira.model.Chamado;
import br.com.sira.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> listarTodos() {
        return chamadoRepository.listarTodos();
    }

    public void inserir(Chamado chamado) {
        chamadoRepository.inserir(chamado);
    }
} 