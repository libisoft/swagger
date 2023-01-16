package co.com.libisoft.swagger.domain.service;

import co.com.libisoft.swagger.domain.dto.Purchase;
import co.com.libisoft.swagger.domain.dto.UsuarioDto;
import co.com.libisoft.swagger.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UsuarioDto> getAll() {
        return repository.getAll();
    }

    public Optional<List<UsuarioDto>> getByDocumento(String documento) {

        return repository.getByDocumento(documento);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {

        return repository.save(usuarioDto);
    }

}
