// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Animal;
import com.sgraa.model.Resgate;
import com.sgraa.repository.AnimalRepository;
import com.sgraa.repository.ResgateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Resgate".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e os repositórios,
 * aplicando regras de negócio e operações relacionadas a resgates de animais.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class ResgateService {

    // Repositório utilizado para acessar e manipular dados relacionados a resgates
    private final ResgateRepository resgateRepository;

    // Repositório utilizado para acessar e manipular dados relacionados a animais
    private final AnimalRepository animalRepository;

    /**
     * Construtor que recebe os repositórios de resgate e animais como dependências.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * instâncias de ResgateRepository e AnimalRepository quando o serviço é criado.
     *
     * @param resgateRepository Repositório de resgates.
     * @param animalRepository Repositório de animais.
     */
    public ResgateService(ResgateRepository resgateRepository, AnimalRepository animalRepository) {
        this.resgateRepository = resgateRepository;
        this.animalRepository = animalRepository;
    }

    /**
     * Método para listar todos os resgates cadastrados no sistema.
     *
     * @return Uma lista contendo todos os resgates.
     */
    public List<Resgate> listarTodos() {
        return resgateRepository.findAll();
    }

    /**
     * Método para salvar um novo resgate no sistema.
     * Este método valida os animais associados ao resgate, verifica se eles existem no banco de dados
     * e persiste o resgate com os animais validados.
     *
     * @param resgate O resgate a ser salvo.
     * @return O resgate salvo, incluindo seus animais associados.
     * @throws RuntimeException Se um ou mais animais associados ao resgate não existirem no banco de dados.
     */
    public Resgate salvar(Resgate resgate) {
        // Buscar os animais no banco de dados pelos IDs informados
        List<Animal> animaisValidos = resgate.getAnimais().stream()
                .map(animal -> animalRepository.findById(animal.getId())) // Busca cada animal pelo ID
                .filter(Optional::isPresent) // Filtra apenas os animais que existem no banco
                .map(Optional::get) // Obtém o valor do Optional (o animal encontrado)
                .collect(Collectors.toList()); // Coleta os animais válidos em uma lista

        // Verifica se todos os IDs informados realmente existem no banco
        if (animaisValidos.isEmpty() || animaisValidos.size() != resgate.getAnimais().size()) {
            throw new RuntimeException("Um ou mais animais não existem no banco de dados.");
        }

        // Associar os animais validados ao resgate antes de salvar
        resgate.setAnimais(animaisValidos);

        // Persiste o resgate no banco de dados
        return resgateRepository.save(resgate);
    }
}
