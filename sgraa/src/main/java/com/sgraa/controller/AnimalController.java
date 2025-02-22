package com.sgraa.controller;

import com.sgraa.model.Animal;
import com.sgraa.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/animais") // Define o endpoint base para requisições
public class AnimalController {
    private final AnimalService animalService;

    // Injeta o serviço de Animal no controlador
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping // Mapeia requisições GET para listar todos os animais
    public List<Animal> listar() {
        return animalService.listarTodos();
    }

    @PostMapping // Mapeia requisições POST para cadastrar um novo animal
    public Animal criar(@RequestBody Animal animal) {
        return animalService.salvar(animal);
    }
}
