package br.com.ohgestor.msadmin.api.repositories;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByCpfOuCnpj(String documento);

    @Query("SELECT c FROM Cliente c WHERE c.ativo = true AND c.integrado = false")
    List<Cliente> findClientesAtivosNaoIntegrados();
}
