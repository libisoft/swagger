package co.com.libisoft.swagger.domain.dto;

public class RolDto {
    private Long rolId;
    private String nombre;

    public RolDto() {
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
