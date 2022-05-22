package com.tim23.fishnchill.security;

import com.tim23.fishnchill.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

// Utility klasa za rad sa JSON Web Tokenima
@Component
public class TokenUtils {

    // Izdavac tokena
    @Value("fishNChill")
    private String appName;

    // Tajna koju samo backend aplikacija treba da zna kako bi mogla da generise i proveri JWT https://jwt.io/
    @Value("somesecret")
    public String secret;

    // Period vazenja
    @Value("300000000")
    private int expiresIn;

    // Naziv headera kroz koji ce se prosledjivati JWT u komunikaciji server-klijent
    @Value("Authorization")
    private String authHeader;

    // Moguce je generisati JWT za razlicite klijente (npr. web i mobilni klijenti nece imati isto trajanje JWT, JWT za mobilne klijente ce trajati duze jer se mozda aplikacija redje koristi na taj nacin)
    private static final String AUDIENCE_WEB = "web";

    // Algoritam za potpisivanje JWT
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    // Funkcija za generisanje JWT token
    public String generateToken(String username, String id) {
        return Jwts.builder()
                .setIssuer(appName)
                .setSubject(username)
                .setAudience(AUDIENCE_WEB)
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .setId(id)
                // .claim("key", value) //moguce je postavljanje proizvoljnih podataka u telo JWT tokena
                .signWith(SIGNATURE_ALGORITHM, secret).compact();
    }

    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + expiresIn);
    }

    // Funkcija za refresh JWT tokena
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            claims.setIssuedAt(new Date());
            refreshedToken = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(generateExpirationDate())
                    .signWith(SIGNATURE_ALGORITHM, secret).compact();
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = this.getIssuedAtDateFromToken(token);
        return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset))
                && (!(this.isTokenExpired(token))));
    }

    // Funkcija za validaciju JWT tokena
    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);

        return (username != null && username.equals(userDetails.getUsername())
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
    }
    public String getIdFromToken(String token) {
        String id;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            id = claims.getId();
        } catch (Exception e) {
            id = null;
        }
        return id;
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public int getExpiredIn() {
        return expiresIn;
    }

    // Funkcija za preuzimanje JWT tokena iz zahteva
    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);

        // JWT se prosledjuje kroz header Authorization u formatu:
        // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(authHeader);
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Funkcija za citanje svih podataka iz JWT tokena
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}