package com.hackthon.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    // Leer la clave secreta desde application.yml
    @Value("${jwt.secret}") // Value permite leer valores desde el archivo application.yml
    private String SECRET_KEY;

    // Leer la expiración desde application.yml
    @Value("${jwt.expiration}")
    private long EXPIRATION_TIME;

    // Generar token
    public String generarToken(String username) {
        return Jwts.builder() // empieza a construir un token JWT.
                .setSubject(username) // define el subject (usuario dueño del token).
                .setIssuedAt(new Date(System.currentTimeMillis()))  // fecha de creación del token.
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // fecha de expiración (tiempo actual + lo definido en configuración)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // firma el token con HMAC-SHA256 usando la clave secreta.
                .compact(); // finaliza y genera el string del token JWT.
    }

    // Extraer username del token
    public String extraerUsername(String token) {
        return extraerClaim(token, Claims::getSubject);
    }

    // Validar si token pertenece al usuario y no expiró
    public boolean validarToken(String token, String username) {
        return (username.equals(extraerUsername(token)) && !estaExpirado(token));
    }

    // Métodos privados auxiliares
    private boolean estaExpirado(String token) {
        return extraerExpiracion(token).before(new Date());
    }

    private Date extraerExpiracion(String token) {
        return extraerClaim(token, Claims::getExpiration);
    }

    private <T> T extraerClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extraerTodosClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extraerTodosClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
