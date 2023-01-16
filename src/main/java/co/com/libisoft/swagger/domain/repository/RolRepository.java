package co.com.libisoft.swagger.domain.repository;

import co.com.libisoft.swagger.domain.dto.Product;
import co.com.libisoft.swagger.domain.dto.RolDto;

import java.util.List;
import java.util.Optional;

public interface RolRepository {

    public List<RolDto> getAll();
    Optional<RolDto> getRol(Long rolId);
    RolDto save(RolDto rol);
    void delete(Long rolId);
}
