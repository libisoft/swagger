package co.com.libisoft.swagger.domain.service;

import co.com.libisoft.swagger.domain.dto.UsuarioDto;
import co.com.libisoft.swagger.persistence.entity.Rol;
import co.com.libisoft.swagger.persistence.mapper.RolMapper;
import co.com.libisoft.swagger.persistence.repo.UsiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SwaggerUserDetailService implements UserDetailsService {
    @Autowired
    private UsiarioRepository repository;
    @Autowired
    RolMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return getUser(username);
        //return new User("admin","{noop}admin",new ArrayList<>());
    }

    private User getUser(String username){
        UsuarioDto usuario = repository.getByNombreUsuario(username);
        List<Rol> rols = mapper.toRols(usuario.getRoles());
        Collection<Rol> roles=new ArrayList<>(rols);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol:roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
       return new User(usuario.getNameUser(),usuario.getPassword(),authorities);

    }
}
