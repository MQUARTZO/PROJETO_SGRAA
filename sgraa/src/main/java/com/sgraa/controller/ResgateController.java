// Define o pacote onde esta classe está localizada
package com.sgraa.controller;

// Importa as classes necessárias para o funcionamento do controlador
import com.sgraa.model.Resgate;
import com.sgraa.service.ResgateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que esta classe é um controlador REST
@RestController
// Define o caminho base para todas as requisições neste controlador
@RequestMapping("/api/resgates")
public class ResgateController {

    // Injeção de dependência do serviço que lida com a lógica de negócio relacionada a Resgates
    private final ResgateService service;

    // Construtor que recebe o serviço como parâmetro (injeção de dependência)
    public ResgateController(ResgateService service) {
        this.service = service;
    }

    // Método que responde a requisições GET no caminho /api/resgates
    // Retorna uma lista de todos os resgates cadastrados
    @GetMapping
    public List<Resgate> listar() {
        return service.listarTodos();
    }

    // Método que responde a requisições POST no caminho /api/resgates
    // Recebe um objeto Resgate no corpo da requisição e o salva no banco de dados
    @PostMapping
    public Resgate criar(@RequestBody Resgate resgate) {
        return service.salvar(resgate);
    }
}
