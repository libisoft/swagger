package co.com.libisoft.swagger.persistence.crud;

import co.com.libisoft.swagger.persistence.entity.Producto;
import co.com.libisoft.swagger.persistence.entity.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolCrudRepository  extends CrudRepository<Rol, Long> {
}
