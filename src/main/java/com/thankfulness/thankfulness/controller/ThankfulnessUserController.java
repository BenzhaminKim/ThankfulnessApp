package com.thankfulness.thankfulness.controller;

import com.thankfulness.thankfulness.Config.JwtUtil;
import com.thankfulness.thankfulness.model.AuthenticationRequest;
import com.thankfulness.thankfulness.model.AuthenticationResponse;
import com.thankfulness.thankfulness.model.ThankfulnessUser;
import com.thankfulness.thankfulness.model.Token;
import com.thankfulness.thankfulness.service.ThankfulnessUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/security")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ThankfulnessUserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ThankfulnessUserService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest request) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password" , e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/authenticate")
    public ThankfulnessUser createUser(@Valid @RequestBody ThankfulnessUser user){
        return userDetailsService.save(user);
    }

    @GetMapping("/authenticate/{token}")
    public ThankfulnessUser getUser(@PathVariable String token){
        return userDetailsService.findUserByToken(token);
    }


    @PostMapping("/userid")
    public UUID getUserId(@Valid @RequestBody Token token){
        String username = jwtUtil.extractUsername(token.getToken());
        return userDetailsService.findUserIdByUsername(username);
    }

    @PostMapping("/validate")
    public Boolean isTokenValidate(@Valid @RequestBody Token token){
        if(token.getToken() == null){
            return Boolean.FALSE;
        }
        final String username = jwtUtil.extractUsername(token.getToken());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        return jwtUtil.validateToken(token.getToken(), userDetails);
    }
}
