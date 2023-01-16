package co.com.libisoft.swagger.web.controller.base;

import co.com.libisoft.swagger.domain.dto.Product;
import co.com.libisoft.swagger.domain.dto.RolDto;
import co.com.libisoft.swagger.domain.service.ProductService;
import co.com.libisoft.swagger.domain.service.RolService;
import co.com.libisoft.swagger.persistence.entity.Rol;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping("/all")
    @ApiOperation("Get all roles")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<RolDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a rol with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Rol not found"),
    })
    public ResponseEntity<RolDto> getProduct(@ApiParam(value = "The id of the rol", required = true, example = "7")
                                              @PathVariable("id") Long rolId) {
        return service.getRol(rolId)
                .map(rol-> new ResponseEntity<>(rol,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @PostMapping("/save")
    public ResponseEntity<RolDto> save(@RequestBody RolDto rol) {
        return new ResponseEntity<>(service.save(rol), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long rolId) {
        if (service.delete(rolId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
