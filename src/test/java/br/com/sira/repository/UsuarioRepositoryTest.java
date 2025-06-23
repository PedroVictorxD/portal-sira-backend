package br.com.sira.repository;

import br.com.sira.model.Usuario;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsuarioRepositoryTest {

    private static UsuarioRepository usuarioRepository;

    @BeforeClass
    public static void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
        usuarioRepository = ctx.getBean(UsuarioRepository.class);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        Usuario usuario = usuarioRepository.findByUsernameAndPassword("admin", "admin");
        Assert.assertNotNull("Usuário deve ser encontrado", usuario);
        Assert.assertEquals("admin", usuario.getUsername());
    }
} 