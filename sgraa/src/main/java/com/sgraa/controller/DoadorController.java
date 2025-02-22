// Define o pacote onde esta classe está localizada
package com.sgraa.controller;

// Importa as classes necessárias para o funcionamento do controlador
import com.sgraa.model.Doador;
import com.sgraa.service.DoadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que esta classe é um controlador REST
@RestController
// Define o caminho base para todas as requisições neste controlador
@RequestMapping("/api/doadores")
public class DoadorController {

    // Injeção de dependência do serviço que lida com a lógica de negócio relacionada a Doadores
    private final DoadorService service;

    // Construtor que recebe o serviço como parâmetro (injeção de dependência)
    public DoadorController(DoadorService service) {
        this.service = service;
    }

    // Método que responde a requisições GET no caminho /api/doadores
    // Retorna uma lista de todos os doadores cadastrados
    @GetMapping
    public List<Doador> listar() {
        return service.listarTodos();
    }

    // Método que responde a requisições POST no caminho /api/doadores
    // Recebe um objeto Doador no corpo da requisição e o salva no banco de dados
    @PostMapping
    public Doador criar(@RequestBody Doador doador) {
        return service.salvar(doador);
    }

    // Método que responde a requisições DELETE no caminho /api/doadores/{id}
    // Recebe o ID do doador como parâmetro na URL e deleta o doador correspondente
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
