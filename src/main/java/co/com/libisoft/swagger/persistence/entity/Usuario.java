package co.com.libisoft.swagger.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios",uniqueConstraints = @UniqueConstraint(columnNames = "usuario"))
public class Usuario extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUsuario;
    @Column(name = "usuario")
    private String nombreUsuario;

    @Column(name = "password")
    private String contrasenia;

    @Column(name = "active")
    private Boolean estado;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id_rol")
    )
    private Collection<Rol> rols;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String contrasenia, Boolean estado, Collection<Rol> rols) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.rols = rols;
    }

    public Usuario(String nombreUsuario, String contrasenia, Boolean estado, Collection<Rol> rols) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.rols = rols;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Collection<Rol> getRols() {
        return rols;
    }

    public void setRols(Collection<Rol> rols) {
        this.rols = rols;
    }
}
