package br.com.ohgestor.msadmin.api.repositories;

import br.com.ohgestor.msadmin.api.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
