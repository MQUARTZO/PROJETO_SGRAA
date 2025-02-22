package com.sgraa.controller;

import com.sgraa.model.Adocao;
import com.sgraa.service.AdocaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas a adoções.
 * Define endpoints para listar e salvar adoções.
 */
@RestController
@RequestMapping("/api/adocoes") // Define o caminho base para os endpoints deste controlador
public class AdocaoController {
    private final AdocaoService adocaoService;

    /**
     * Construtor para injetar a dependência do serviço de adoção.
     * @param adocaoService Serviço responsável pelas regras de negócio relacionadas à adoção.
     */
    public AdocaoController(AdocaoService adocaoService) {
        this.adocaoService = adocaoService;
    }

    /**
     * Endpoint para listar todas as adoções registradas.
     * @return ResponseEntity contendo a lista de todas as adoções.
     */
    @GetMapping
    public ResponseEntity<List<Adocao>> listarTodos() {
        return ResponseEntity.ok(adocaoService.listarTodos());
    }

    /**
     * Endpoint para salvar uma nova adoção.
     * @param adocao Objeto recebido no corpo da requisição representando a adoção a ser salva.
     * @return ResponseEntity contendo a adoção salva.
     */
    @PostMapping
    public ResponseEntity<Adocao> salvar(@RequestBody Adocao adocao) {
        return ResponseEntity.ok(adocaoService.salvar(adocao));
    }
}
