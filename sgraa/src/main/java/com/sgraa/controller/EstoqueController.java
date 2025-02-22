// Define o pacote onde esta classe está localizada
package com.sgraa.controller;

// Importa as classes necessárias para o funcionamento do controlador
import com.sgraa.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Anotação que indica que esta classe é um controlador REST
@RestController
// Define o caminho base para todas as requisições neste controlador
@RequestMapping("/api/estoque")
public class EstoqueController {

    // Injeção de dependência do serviço que lida com a lógica de negócio relacionada ao estoque
    private final EstoqueService estoqueService;

    // Construtor que recebe o serviço como parâmetro (injeção de dependência)
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    // Endpoint para consumir um item do estoque
    // Mapeia requisições HTTP POST no caminho /api/estoque/consumir
    @PostMapping("/consumir")
    public ResponseEntity<String> consumirItem(@RequestBody Map<String, Object> request) {
        // Extrai o nome do item do corpo da requisição
        String item = (String) request.get("item");
        // Extrai a quantidade a ser consumida do corpo da requisição
        int quantidade = (int) request.get("quantidade");

        // Chama o serviço para tentar consumir o item do estoque
        boolean sucesso = estoqueService.consumirItem(item, quantidade);

        // Verifica se o consumo foi bem-sucedido
        if (!sucesso) {
            // Se não houver estoque suficiente, retorna uma resposta de erro com status 400 (Bad Request)
            return ResponseEntity.badRequest().body("Estoque insuficiente para o item: " + item);
        }

        // Se o consumo for bem-sucedido, retorna uma resposta de sucesso com status 200 (OK)
        return ResponseEntity.ok("Item consumido com sucesso!");
    }
}
