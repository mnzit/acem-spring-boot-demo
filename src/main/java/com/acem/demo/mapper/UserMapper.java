package com.acem.demo.mapper;

import com.acem.demo.entity.User;
import com.acem.demo.response.UserListResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserListResponse map(User user){
        UserListResponse.UserListResponseBuilder userListResponseBuilder = UserListResponse
                .builder()
                .firstName(user.getName().getFirstName())
                .middleName(user.getName().getMiddleName())
                .lastName(user.getName().getLastName())
                .email(user.getEmail())
                .contactNo(user.getContactNo())
                .role(user.getRole().getName())
                .authorities(user.getAuthorities().stream().map(object -> Objects.toString(object,null))
                        .collect(Collectors.toList()));

    UserListResponse userListResponse = userListResponseBuilder.build();
    return  userListResponse;
    }
}
