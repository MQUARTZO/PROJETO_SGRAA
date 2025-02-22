package com.sgraa.controller;

import com.sgraa.model.Doacao;
import com.sgraa.service.DoacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define a classe como um controlador REST
@RequestMapping("/api/doacoes") // Mapeia todas as requisições para o caminho "/api/doacoes"
public class DoacaoController {
    private final DoacaoService doacaoService;

    // Injeta o serviço de doação no controlador
    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    // Endpoint para listar todas as doações cadastradas
    @GetMapping
    public ResponseEntity<List<Doacao>> listarTodos() {
        return ResponseEntity.ok(doacaoService.listarTodos()); // Retorna a lista de doações com status HTTP 200 (OK)
    }

    // Endpoint para cadastrar uma nova doação
    @PostMapping
    public ResponseEntity<Doacao> salvar(@RequestBody Doacao doacao) {
        return ResponseEntity.ok(doacaoService.salvar(doacao)); // Salva a doação e retorna o objeto criado com status 200 (OK)
    }
}
