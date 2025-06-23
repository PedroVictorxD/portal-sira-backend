package br.com.sira.service;

import br.com.sira.model.Usuario;
import br.com.sira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }
} 