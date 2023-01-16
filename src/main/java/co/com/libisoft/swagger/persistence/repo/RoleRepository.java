package co.com.libisoft.swagger.persistence.repo;

import co.com.libisoft.swagger.domain.dto.Product;
import co.com.libisoft.swagger.domain.dto.RolDto;
import co.com.libisoft.swagger.domain.repository.RolRepository;
import co.com.libisoft.swagger.persistence.crud.RolCrudRepository;
import co.com.libisoft.swagger.persistence.entity.Producto;
import co.com.libisoft.swagger.persistence.entity.Rol;
import co.com.libisoft.swagger.persistence.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository implements RolRepository {

    @Autowired
    private RolCrudRepository repository;

    @Autowired
    private RolMapper mapper;

    @Override
    public List<RolDto> getAll() {

        List<Rol> roles = (List<Rol>) repository.findAll();
        return mapper.toRolDtos(roles);
    }

    @Override
    public Optional<RolDto> getRol(Long rolId) {

        return repository.findById(rolId).map(rol -> mapper.toRolDto(rol));
    }

    @Override
    public RolDto save(RolDto rol) {
        Rol role = mapper.toCRol(rol);
        return mapper.toRolDto(repository.save(role));
    }

    @Override
    public void delete(Long rolId) {
        repository.deleteById(rolId);
    }
}
