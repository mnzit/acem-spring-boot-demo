package com.acem.demo.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNo;
    private String role;
    private List<String> authorities;
}
