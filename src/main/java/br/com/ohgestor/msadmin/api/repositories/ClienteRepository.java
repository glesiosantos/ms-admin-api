package br.com.ohgestor.msadmin.api.repositories;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpfOuCnpj(String documento);
}
