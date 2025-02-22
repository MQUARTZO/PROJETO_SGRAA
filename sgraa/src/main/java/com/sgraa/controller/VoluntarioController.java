// Define o pacote onde esta classe está localizada
package com.sgraa.controller;

// Importa as classes necessárias para o funcionamento do controlador
import com.sgraa.model.Voluntario;
import com.sgraa.service.VoluntarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação que indica que esta classe é um controlador REST
@RestController
// Define o caminho base para todas as requisições neste controlador
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    // Injeção de dependência do serviço que lida com a lógica de negócio relacionada a Voluntários
    private final VoluntarioService service;

    // Construtor que recebe o serviço como parâmetro (injeção de dependência)
    public VoluntarioController(VoluntarioService service) {
        this.service = service;
    }

    // Método que responde a requisições GET no caminho /api/voluntarios
    // Retorna uma lista de todos os voluntários cadastrados
    @GetMapping
    public List<Voluntario> listar() {
        return service.listarTodos();
    }

    // Método que responde a requisições POST no caminho /api/voluntarios
    // Recebe um objeto Voluntario no corpo da requisição e o salva no banco de dados
    @PostMapping
    public Voluntario criar(@RequestBody Voluntario voluntario) {
        return service.salvar(voluntario);
    }
}
