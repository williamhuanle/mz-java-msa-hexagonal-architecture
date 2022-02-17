package mz.co.kr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mz.co.kr.domain.enums.OAuth2Provider;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private Boolean emailVerified = false;
    private String password;
    private OAuth2Provider provider;
    private String providerId;

}
