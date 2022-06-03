package com.rd.userservice.payload;

import lombok.Data;

/**
 * Created at 2.06.2022.
 *
 * @author Ridvan Dogan
 */
@Data
public class RoleToUserPayload {
    private String userName;
    private String roleName;
}
