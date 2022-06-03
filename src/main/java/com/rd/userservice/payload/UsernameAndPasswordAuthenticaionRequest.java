package com.rd.userservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created at 2.06.2022.
 *
 * @author Ridvan Dogan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernameAndPasswordAuthenticaionRequest {
    private String username;
    private String password;
}
