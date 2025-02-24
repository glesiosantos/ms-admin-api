package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.web.requests.UsuarioRequest;

import java.util.List;

public interface UsuarioService {

    Usuario cadastraUsuario(UsuarioRequest request) throws Exception;

    List<Usuario> carregarUsuarios();

    void updateDadosUsuario(Usuario usuario);

    Usuario buscarPeloEmail(String email) throws Exception;
}
