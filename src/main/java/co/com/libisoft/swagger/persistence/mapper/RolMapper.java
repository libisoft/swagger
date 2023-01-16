package co.com.libisoft.swagger.persistence.mapper;

import co.com.libisoft.swagger.domain.dto.Category;
import co.com.libisoft.swagger.domain.dto.Product;
import co.com.libisoft.swagger.domain.dto.RolDto;
import co.com.libisoft.swagger.persistence.entity.Categoria;
import co.com.libisoft.swagger.persistence.entity.Producto;
import co.com.libisoft.swagger.persistence.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    @Mappings({
            @Mapping(source = "rolid", target = "rolId"),
            @Mapping(source = "nombre", target = "nombre")
    })
    RolDto toRolDto(Rol rol);
    List<RolDto> toRolDtos(List<Rol> roles);
    @InheritInverseConfiguration
    Rol toCRol(RolDto rol);
    List<Rol> toRols(List<RolDto> roles);
}
