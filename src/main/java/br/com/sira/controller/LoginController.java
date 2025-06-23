package br.com.sira.controller;

import br.com.sira.model.Usuario;
import br.com.sira.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String showLoginForm() {
        return "login";
    }

    @PostMapping
    public ModelAndView processLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpSession session) {
        Usuario usuario = usuarioService.autenticar(username, password);
        ModelAndView mv = new ModelAndView();
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            mv.setViewName("redirect:/forum");
        } else {
            mv.setViewName("login");
            mv.addObject("error", "Usuário ou senha inválidos");
        }
        return mv;
    }
} 