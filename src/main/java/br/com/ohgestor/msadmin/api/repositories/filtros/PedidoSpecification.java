package br.com.ohgestor.msadmin.api.repositories.filtros;

import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.services.filtros.PedidoFiltro;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoSpecification {

    public static Specification<Pedido> comFiltros(PedidoFiltro filtro) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!filtro.dataInicial().isEmpty() && !filtro.dataFinal().isEmpty()) {
                predicates.add(criteriaBuilder.between(
                        root.get("dtCriadoEm"), // Ajuste o nome do campo conforme sua entidade
                        LocalDate.parse(filtro.dataInicial()),
                        LocalDate.parse(filtro.dataFinal())
                ));
            }

            if(!filtro.situacao().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("situacao"), filtro.situacao()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
