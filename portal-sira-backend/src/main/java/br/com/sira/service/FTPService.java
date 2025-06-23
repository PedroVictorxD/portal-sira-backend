package br.com.sira.service;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FTPService {
    private String servidor = "ftp.seuservidor.com";
    private int porta = 21;
    private String usuario = "ftpuser";
    private String senha = "ftppass";

    public boolean uploadArquivo(String caminhoLocal, String nomeRemoto) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(servidor, porta);
            ftp.login(usuario, senha);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            try (FileInputStream fis = new FileInputStream(caminhoLocal)) {
                return ftp.storeFile(nomeRemoto, fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { ftp.logout(); ftp.disconnect(); } catch (Exception ignored) {}
        }
    }

    public boolean downloadArquivo(String nomeRemoto, String caminhoLocal) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(servidor, porta);
            ftp.login(usuario, senha);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            try (FileOutputStream fos = new FileOutputStream(caminhoLocal)) {
                return ftp.retrieveFile(nomeRemoto, fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { ftp.logout(); ftp.disconnect(); } catch (Exception ignored) {}
        }
    }
} 