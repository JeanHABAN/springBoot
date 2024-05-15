package com.mock.mock.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtAuthenticationController {
    @Autowired
    private Refreshjwt refreshjwt;

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        try {
            if (refreshjwt.validateToken(requestRefreshToken)) {
                String username = refreshjwt.extractUsername(requestRefreshToken);
                String token = refreshjwt.generateToken(username);
                return ResponseEntity.ok(new AuthenticationResponse(token, requestRefreshToken));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid Refresh Token");
        }
        return ResponseEntity.badRequest().body("Invalid Request");
    }
}

    class TokenRefreshRequest {
        private String refreshToken;

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }

class AuthenticationResponse {
    private String jwt;
    private String refreshToken;

    public AuthenticationResponse(String jwt, String refreshToken) {
        this.jwt = jwt;
        this.refreshToken = refreshToken;
    }

    public String getJwt() {
        return jwt;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}