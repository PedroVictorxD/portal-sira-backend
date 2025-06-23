package br.com.sira.controller;

import br.com.sira.model.Chamado;
import br.com.sira.model.Usuario;
import br.com.sira.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public String listarChamados(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        List<Chamado> chamados = chamadoService.listarTodos();
        model.addAttribute("chamados", chamados);
        model.addAttribute("novoChamado", new Chamado());
        return "chamados";
    }

    @PostMapping
    public String abrirChamado(@ModelAttribute("novoChamado") Chamado chamado, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        chamado.setUsuarioAbertura(usuario);
        chamado.setDataHoraAbertura(LocalDateTime.now());
        chamado.setStatus("ABERTO");
        chamadoService.inserir(chamado);
        return "redirect:/chamados";
    }
} 