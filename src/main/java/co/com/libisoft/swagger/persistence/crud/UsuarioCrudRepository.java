package co.com.libisoft.swagger.persistence.crud;

import co.com.libisoft.swagger.persistence.entity.Compra;
import co.com.libisoft.swagger.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Long> {

    Usuario findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findTopByOrderByIdUsuarioDesc();
}
