package com.acem.demo.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserListResponse implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNo;
    private String role;
    private List<String> authorities;
}
