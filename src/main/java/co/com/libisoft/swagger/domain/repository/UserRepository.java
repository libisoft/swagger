package co.com.libisoft.swagger.domain.repository;

import co.com.libisoft.swagger.domain.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UsuarioDto> getAll();
    Optional<List<UsuarioDto>> getByDocumento(String documento);
    UsuarioDto save(UsuarioDto usuarioDto);

   UsuarioDto getByNombreUsuario(String nombreUsuario);
}
