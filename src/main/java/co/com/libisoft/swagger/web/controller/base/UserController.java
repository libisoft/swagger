package co.com.libisoft.swagger.web.controller.base;

import co.com.libisoft.swagger.domain.dto.Purchase;
import co.com.libisoft.swagger.domain.dto.UsuarioDto;
import co.com.libisoft.swagger.domain.service.PurchaseService;
import co.com.libisoft.swagger.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<List<UsuarioDto>> getByClient(@PathVariable("documento") String documento) {
        return service.getByDocumento(documento).map(
                usuarioDtos -> new ResponseEntity<>(usuarioDtos, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto) {

        return new ResponseEntity<>(service.save(usuarioDto), HttpStatus.CREATED);
    }
}
