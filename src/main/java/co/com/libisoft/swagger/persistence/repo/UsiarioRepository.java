package co.com.libisoft.swagger.persistence.repo;

import co.com.libisoft.swagger.domain.dto.UsuarioDto;
import co.com.libisoft.swagger.domain.repository.UserRepository;
import co.com.libisoft.swagger.persistence.crud.UsuarioCrudRepository;
import co.com.libisoft.swagger.persistence.entity.Rol;
import co.com.libisoft.swagger.persistence.entity.Usuario;
import co.com.libisoft.swagger.persistence.mapper.RolMapper;
import co.com.libisoft.swagger.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class UsiarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;
    @Autowired
    private RolMapper rolMapper;

    @Override
    public List<UsuarioDto> getAll() {
        return mapper.toUsuarioDtos((List<Usuario>) usuarioCrudRepository.findAll());
    }

    @Override
    public Optional<List<UsuarioDto>> getByDocumento(String documento) {

       /* return usuarioCrudRepository.findByIdentificacion(documento)
                .map(usuarios -> mapper.toUsuarioDtos(usuarios));*/
        return null;
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario= new Usuario();
        if(usuarioDto.getIdPerona()==null){

            String pass="{noop}"+usuarioDto.getPassword();
            System.out.println("pass: "+pass);
           usuarioDto.setPassword(pass);

        }else{
            usuario.setIdUsuario(usuarioDto.getIdPerona());
        }
        usuario.setContrasenia(usuarioDto.getPassword());
        usuario.setNombreUsuario(usuarioDto.getNameUser());
        usuario.setEstado(usuarioDto.getActive());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setCelular(usuarioDto.getCelular());
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNombres(usuarioDto.getNombres());
        usuario.setIdentificacion(usuarioDto.getIdentificacion());
        List<Rol> rols = rolMapper.toRols(usuarioDto.getRoles());
        Collection<Rol> roles=new ArrayList<>(rols);
        usuario.setRols(roles);

        return mapper.toUsuarioDto(usuarioCrudRepository.save(usuario));
    }

    @Override
    public UsuarioDto getByNombreUsuario(String nombreUsuario) {
        return mapper.toUsuarioDto(usuarioCrudRepository.findByNombreUsuario(nombreUsuario));
    }

    private Long getLastUser(){
        Usuario usurio = usuarioCrudRepository.findTopByOrderByIdUsuarioDesc().orElse(new Usuario());
        return usurio.getIdUsuario();
    }


}
