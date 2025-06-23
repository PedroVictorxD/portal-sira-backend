package br.com.sira.controller;

import br.com.sira.model.ComentarioOcorrencia;
import br.com.sira.model.Ocorrencia;
import br.com.sira.model.Usuario;
import br.com.sira.service.ComentarioOcorrenciaService;
import br.com.sira.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private ComentarioOcorrenciaService comentarioOcorrenciaService;

    @GetMapping
    public String listarOcorrencias(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarTodas();
        model.addAttribute("ocorrencias", ocorrencias);
        return "forum";
    }

    @GetMapping("/{ocorrenciaId}")
    public String detalhesOcorrencia(@PathVariable Long ocorrenciaId, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        // Buscar ocorrência e comentários
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarTodas();
        Ocorrencia ocorrencia = ocorrencias.stream().filter(o -> o.getId().equals(ocorrenciaId)).findFirst().orElse(null);
        List<ComentarioOcorrencia> comentarios = comentarioOcorrenciaService.listarPorOcorrencia(ocorrenciaId);
        model.addAttribute("ocorrencia", ocorrencia);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("novoComentario", new ComentarioOcorrencia());
        return "forum";
    }

    @PostMapping("/{ocorrenciaId}/comentar")
    public String comentarOcorrencia(@PathVariable Long ocorrenciaId, @ModelAttribute("novoComentario") ComentarioOcorrencia comentario, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        comentario.setUsuario(usuario);
        comentario.setDataHora(LocalDateTime.now());
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(ocorrenciaId);
        comentario.setOcorrencia(ocorrencia);
        comentarioOcorrenciaService.inserir(comentario);
        return "redirect:/forum/" + ocorrenciaId;
    }
} 