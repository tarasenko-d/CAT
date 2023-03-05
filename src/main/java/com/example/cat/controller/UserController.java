package com.example.cat.controller;

import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.request.FollowEventRequest;
import com.example.cat.dto.request.GetUserByIdRequest;
import com.example.cat.dto.request.UnfollowEventRequest;
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

    @PostMapping("/follow")
    // TODO: user -> principal
    public IntegrationMessage followEvent(@RequestBody IntegrationMessage<FollowEventRequest> request) {
        try {
            Optional<Long> eventId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(FollowEventRequest::getEventId);

            if (eventId.isEmpty()) {
                return IntegrationMessage.errorResponse("Не введены данные события", request);
            }

            Optional<Long> userId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(FollowEventRequest::getUserId);

            if (userId.isEmpty()) {
                return IntegrationMessage.errorResponse("Не введены данные пользователя", request);
            }


            User user = userService.followEvent(userId.get(), eventId.get());

            return IntegrationMessage.successResponse(user, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }

    @PostMapping("/unfollow")
    // TODO: user -> principal
    public IntegrationMessage unfollowEvent(@RequestBody IntegrationMessage<UnfollowEventRequest> request) {
        try {
            Optional<Long> eventId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(UnfollowEventRequest::getEventId);

            if (eventId.isEmpty()) {
                return IntegrationMessage.errorResponse("Не введены данные события", request);
            }

            Optional<Long> userId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(UnfollowEventRequest::getUserId);

            if (userId.isEmpty()) {
                return IntegrationMessage.errorResponse("Не введены данные пользователя", request);
            }


            User user = userService.unfollowEvent(userId.get(), eventId.get());

            return IntegrationMessage.successResponse(user, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }
}
