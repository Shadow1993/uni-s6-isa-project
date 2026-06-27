package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;

@Service
public class JWTService {

    private String secretKey = "supersercret";
    public JWTService(){
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        SecretKey sk = keyGen.generateKey();
        secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    }

    public String generateToken(UserModel user){
        Map<String, Object> claims = new HashMap<String, Object>();
        List<String> assignedRoles = new ArrayList<String>();
        for (AssignedRoleModel assignedRole: user.getAssignedRoles()) {
        	assignedRoles.add(assignedRole.getRole().getName());
        }
        claims.put("assignedRoles", assignedRoles);
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)))
                .and()
                .signWith(getKey())
                .compact();
    }

    public String getUsernameFromToken(String token){
        return extractEmail(token);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        Claims claims = Jwts.claims().build();

        claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();


        return claims;
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

}

