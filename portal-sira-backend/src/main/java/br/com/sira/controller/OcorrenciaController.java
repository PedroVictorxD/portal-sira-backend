package br.com.sira.controller;

import br.com.sira.model.Ocorrencia;
import br.com.sira.model.Usuario;
import br.com.sira.service.OcorrenciaService;
import br.com.sira.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarTodas();
        model.addAttribute("ocorrencias", ocorrencias);
        return "ocorrencias-lista";
    }

    @GetMapping("/nova")
    public String novaForm(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "ocorrencia-form";
    }

    @PostMapping
    public String criar(@ModelAttribute Ocorrencia ocorrencia, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        ocorrencia.setUsuario(usuario);
        ocorrenciaService.inserir(ocorrencia);
        return "redirect:/ocorrencias";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Ocorrencia ocorrencia = ocorrenciaService.buscarPorId(id);
        model.addAttribute("ocorrencia", ocorrencia);
        return "ocorrencia-form";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id, @ModelAttribute Ocorrencia ocorrencia) {
        ocorrencia.setId(id);
        ocorrenciaService.atualizar(ocorrencia);
        return "redirect:/ocorrencias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        ocorrenciaService.excluir(id);
        return "redirect:/ocorrencias";
    }

    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Ocorrencia ocorrencia = ocorrenciaService.buscarPorId(id);
        model.addAttribute("ocorrencia", ocorrencia);
        // Comentários serão integrados na view
        return "ocorrencia-detalhe";
    }
} 