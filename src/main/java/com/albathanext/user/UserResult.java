package com.albathanext.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResult {

    private long id;

    private String username;

    private String email;

    private String accessToken;
}
