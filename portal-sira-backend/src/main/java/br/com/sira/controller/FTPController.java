package br.com.sira.controller;

import br.com.sira.service.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/ftp")
public class FTPController {

    @Autowired
    private FTPService ftpService;

    @GetMapping("/download")
    public void downloadArquivo(@RequestParam("arquivo") String nomeArquivo, HttpServletResponse response) throws IOException {
        // Baixar do FTP para um arquivo temporário
        File tempFile = File.createTempFile("download_", nomeArquivo);
        boolean downloaded = ftpService.downloadArquivo(nomeArquivo, tempFile.getAbsolutePath());
        if (downloaded) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");
            try (FileInputStream fis = new FileInputStream(tempFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Arquivo não encontrado no FTP");
        }
        tempFile.delete();
    }
} 