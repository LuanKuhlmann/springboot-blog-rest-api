package io.github.luankuhlmann.springbootblogrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {

    private String accessToken;
    private String tokenType = "Bearer";

}
