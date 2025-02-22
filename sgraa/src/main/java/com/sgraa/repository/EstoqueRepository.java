package com.sgraa.repository;

import com.sgraa.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 * Interface que define o repositório para a entidade "EstoqueRepository".
 * Esta interface estende JpaRepository, fornecendo métodos CRUD padrão e permitindo a criação de consultas personalizadas.
 * Repositórios são responsáveis por abstrair o acesso ao banco de dados e fornecer operações de persistência para a entidade.
 */
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByItem(String item);
}
