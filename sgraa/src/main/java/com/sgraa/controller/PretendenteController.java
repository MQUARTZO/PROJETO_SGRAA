// Define o pacote onde esta classe está localizada
package com.sgraa.controller;

// Importa as classes necessárias para o funcionamento do controlador
import com.sgraa.model.Pretendente;
import com.sgraa.service.PretendenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que esta classe é um controlador REST
@RestController
// Define o caminho base para todas as requisições neste controlador
@RequestMapping("/api/pretendentes")
public class PretendenteController {

    // Injeção de dependência do serviço que lida com a lógica de negócio relacionada a Pretendentes
    private final PretendenteService service;

    // Construtor que recebe o serviço como parâmetro (injeção de dependência)
    public PretendenteController(PretendenteService service) {
        this.service = service;
    }

    // Método que responde a requisições GET no caminho /api/pretendentes
    // Retorna uma lista de todos os pretendentes cadastrados
    @GetMapping
    public List<Pretendente> listar() {
        return service.listarTodos();
    }

    // Método que responde a requisições POST no caminho /api/pretendentes
    // Recebe um objeto Pretendente no corpo da requisição e o salva no banco de dados
    @PostMapping
    public Pretendente criar(@RequestBody Pretendente pretendente) {
        return service.salvar(pretendente);
    }
}
