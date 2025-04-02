package com.pwns.app.mapper;

import com.pwns.app.dto.request.UserRequest;
import com.pwns.app.dto.response.UserResponse;
import com.pwns.app.entity.User;
import com.pwns.app.utils.Sex;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toUser(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .sex(Sex.valueOf(request.sex()))
                .weight(request.weight())
                .height(request.height())
                .bodyFat(request.bodyFat())
                .trainingLevel(request.trainingLevel())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .height(user.getHeight())
                .weight(user.getWeight())
                .build();
    }
}
