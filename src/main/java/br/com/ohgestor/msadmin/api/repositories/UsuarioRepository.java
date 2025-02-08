package br.com.ohgestor.msadmin.api.repositories;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT * FROM usuarios u WHERE u.ativo = true and email = :email", nativeQuery = true)
    Optional<Usuario> findUsuarioAtivoPorEmail(@Param("email") String email);
}
