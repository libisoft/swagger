package co.com.libisoft.swagger.persistence.mapper;

import co.com.libisoft.swagger.domain.dto.UsuarioDto;
import co.com.libisoft.swagger.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario",target = "idPerona"),
            @Mapping(source = "nombreUsuario",target = "nameUser"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "contrasenia",target = "password"),
            @Mapping(source = "rols",target = "roles")


    })
    UsuarioDto toUsuarioDto(Usuario usuario);
    List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(UsuarioDto usuarioDto);
}
