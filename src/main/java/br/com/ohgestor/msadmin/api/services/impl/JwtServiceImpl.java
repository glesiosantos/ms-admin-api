package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.services.JwtService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService {

//    private final static Logger LOGGER = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Value("${api.security.secret}")
    private String secret;

    @Override
    public String tokenGenerate(UserDetails userDetails) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            var scopes = userDetails
                    .getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));

            System.out.println("**** scopes"+ scopes);

            return JWT.create()
                    .withIssuer("ms-admin-api")
                    .withExpiresAt(criarDataExpiracao())
                    .withSubject(userDetails.getUsername())
                    .withClaim("scope", scopes)
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("*** "+ex);
        }
    }

    @Override
    public String validarToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }
    private Instant criarDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
