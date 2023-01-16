package co.com.libisoft.swagger.domain.dto;

import co.com.libisoft.swagger.persistence.entity.Persona;

import java.util.List;

public class UsuarioDto extends Persona {
    private Long idPerona;


    private String nameUser;
    private String password;
    private Boolean active;

    private List<RolDto> roles;


    public UsuarioDto() {
    }

    public Long getIdPerona() {
        return idPerona;
    }

    public void setIdPerona(Long idPerona) {
        this.idPerona = idPerona;
    }



    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<RolDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDto> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "idPerona=" + idPerona +

                ", nameUser='" + nameUser + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +

                '}';
    }
}