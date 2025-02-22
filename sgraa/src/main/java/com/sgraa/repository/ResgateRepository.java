package com.sgraa.repository;

import com.sgraa.model.Resgate;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Interface que define o repositório para a entidade "ResgateRepository".
 * Esta interface estende JpaRepository, fornecendo métodos CRUD padrão e permitindo a criação de consultas personalizadas.
 * Repositórios são responsáveis por abstrair o acesso ao banco de dados e fornecer operações de persistência para a entidade.
 */
public interface ResgateRepository extends JpaRepository<Resgate, Long> {
}
