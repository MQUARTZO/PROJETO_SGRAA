package com.sgraa.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class LoginDTO {
    private String username;
    private String password;

    // Método para validar se o DTO está preenchido corretamente
    public boolean isValid() {
        // Verifica se o username e password não são nulos ou vazios
        return StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password);
    }

    // Método para sanitizar os dados (remover espaços em branco desnecessários)
    public void sanitize() {
        if (username != null) {
            username = username.trim();
        }
        if (password != null) {
            password = password.trim();
        }
    }

    // Método para retornar uma mensagem de erro caso os dados sejam inválidos
    public String getValidationErrorMessage() {
        if (StringUtils.isBlank(username)) {
            return "O campo 'username' não pode estar vazio.";
        }
        if (StringUtils.isBlank(password)) {
            return "O campo 'password' não pode estar vazio.";
        }
        return null; // Retorna null se não houver erros
    }
}
