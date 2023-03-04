package com.example.cat.controller;

import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.request.GetUserByIdRequest;
import com.example.cat.model.User;
import com.example.cat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@SuppressWarnings("rawtypes")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/getUserById")
    public IntegrationMessage getUserById(@RequestBody IntegrationMessage<GetUserByIdRequest> request) {
        try {
            Optional<Long> userId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(GetUserByIdRequest::getUserId);

            if (userId.isEmpty()) {
                return IntegrationMessage.errorResponse("Пользователь не найден", request);
            }

            User user = userService.getUserById(userId.get());

            return IntegrationMessage.successResponse(user, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }
}
