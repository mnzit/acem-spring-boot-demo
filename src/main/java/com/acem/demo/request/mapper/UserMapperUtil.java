package com.acem.demo.request.mapper;


import com.acem.demo.entity.Name;
import com.acem.demo.entity.Role;
import com.acem.demo.entity.User;
import com.acem.demo.request.UserSaveRequest;
import com.acem.demo.request.UserUpdateRequest;
import com.acem.demo.utils.ModelMapperUtil;
import org.springframework.stereotype.Component;

@Component
public class UserMapperUtil {

    public User mapStudent(UserSaveRequest request) {
        User user = new User();
        user.setName(new Name(request.getFirstName(), request.getMiddleName(), request.getLastName()));
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setContactNo(request.getContactNo());
        user.setRole(new Role(request.getRoleId()));

        return user;
    }

    public User mapStudent(UserUpdateRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(new Name(request.getFirstName(), request.getMiddleName(), request.getLastName()));
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setContactNo(request.getContactNo());
        user.setRole(new Role(request.getRoleId()));
        return user;
    }
}
