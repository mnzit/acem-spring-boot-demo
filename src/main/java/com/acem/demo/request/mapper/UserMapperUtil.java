package com.acem.demo.request.mapper;


import com.acem.demo.entity.User;
import com.acem.demo.request.UserSaveRequest;
import com.acem.demo.request.UserUpdateRequest;
import com.acem.demo.utils.ModelMapperUtil;
import org.springframework.stereotype.Component;

@Component
public class UserMapperUtil {

    public User mapStudent(UserSaveRequest userSaveRequest) {
        return ModelMapperUtil.map(userSaveRequest, User.class);
    }

    public User mapStudent(UserUpdateRequest userUpdateRequest) {
        return ModelMapperUtil.map(userUpdateRequest, User.class);
    }
}
