package co.com.libisoft.swagger.web.controller.base;

import co.com.libisoft.swagger.domain.dto.AuthDto;
import co.com.libisoft.swagger.domain.dto.AuthenticationRequest;
import co.com.libisoft.swagger.domain.dto.AuthenticationResponse;
import co.com.libisoft.swagger.domain.service.SwaggerUserDetailService;
import co.com.libisoft.swagger.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AutController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SwaggerUserDetailService service;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authentication")
    public ResponseEntity<AuthDto> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails userDetails=service.loadUserByUsername(request.getUsername());
            String jwt=jwtUtil.generarToken(userDetails);
            Date experide = jwtUtil.extractTokenExpired(jwt);

            return new ResponseEntity<>(new AuthDto(jwt,experide),HttpStatus.OK);
        }catch (BadCredentialsException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
