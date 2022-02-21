package mz.co.kr.controller.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mz.co.kr.auth.domain.enums.OAuth2Provider;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private Boolean emailVerified = false;
    private OAuth2Provider provider;
    private String providerId;
}
