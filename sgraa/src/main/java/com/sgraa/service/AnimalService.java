// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Animal;
import com.sgraa.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Animal".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas aos animais.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class AnimalService {

    // Repositório utilizado para acessar e manipular dados relacionados aos animais
    private final AnimalRepository animalRepository;

    /**
     * Construtor que recebe o repositório de animais como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de AnimalRepository quando o serviço é criado.
     *
     * @param animalRepository Repositório de animais.
     */
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /**
     * Método para listar todos os animais cadastrados no sistema.
     *
     * @return Uma lista contendo todos os animais.
     */
    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    /**
     * Método para salvar um novo animal no sistema.
     * Este método persiste o animal no banco de dados e retorna o animal salvo.
     *
     * @param animal O animal a ser salvo.
     * @return O animal salvo, incluindo seu ID gerado.
     */
    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }
    
}
/**
 * Esta classe pode ser expandida para incluir novos métodos, como validações de animais ou consultas personalizadas.
 */
