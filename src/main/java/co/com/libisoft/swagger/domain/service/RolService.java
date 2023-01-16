package co.com.libisoft.swagger.domain.service;

import co.com.libisoft.swagger.domain.dto.Product;
import co.com.libisoft.swagger.domain.dto.RolDto;
import co.com.libisoft.swagger.domain.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    public List<RolDto> getAll() {
        return repository.getAll();
    }

    public Optional<RolDto> getRol(Long rolId) {
        return repository.getRol(rolId);
    }

    public RolDto save(RolDto rol) {
        return repository.save(rol);
    }

    public boolean delete(Long rolId) {
        return getRol(rolId).map(rol -> {
            repository.delete(rolId);
            return true;
        }).orElse(false);
    }

}
