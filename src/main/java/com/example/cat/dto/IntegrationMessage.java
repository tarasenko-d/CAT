package com.example.cat.dto;

import com.example.cat.dto.response.*;
import com.example.cat.model.Event;
import com.example.cat.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
public class IntegrationMessage<T> {

    private Status status;
    private T data;
    private Description description;

    public static IntegrationMessage<CreateEventResponse> successCreateResponse(Event event) {
        return successCreateResponse(event);
    }

    public static IntegrationMessage<GetEventByIdResponse> successGetResponse(Event event) {
        return successGetResponse(event);
    }

    public static IntegrationMessage<DeleteByIdResponse> successDeleteResponse(Long id){
        return successDeleteResponse(id);
    }

   public static IntegrationMessage<EditEventResponse> successEditResponse (Event event){
        return successEditResponse(event);
    }

    public static IntegrationMessage<GetEventsFilterResponse> successGetResponse(List<Event> events) {
        return successGetResponse(events);
    }

    public static IntegrationMessage<GetUserByIdResponse> successGetResponse(User user) {
        return successGetResponse(user);
    }


    private static <T> IntegrationMessage<T> successGetResponse(T data) {
        IntegrationMessage<T> response = new IntegrationMessage<>();
        response.setData(data);
        response.setStatus(Status.SUCCESS);
        return response;
    }

    private static <T> IntegrationMessage<T> successEditResponse(T data) {
        IntegrationMessage<T> response = new IntegrationMessage<>();
        response.setData(data);
        response.setStatus(Status.SUCCESS);
        return response;
    }

    private static <T> IntegrationMessage<T> successCreateResponse(T data) {
        IntegrationMessage<T> response = new IntegrationMessage<>();
        response.setData(data);
        response.setStatus(Status.SUCCESS);
        return response;
    }

    private static <T> IntegrationMessage<T> successDeleteResponse(T data) {
        IntegrationMessage<T> response = new IntegrationMessage<>();
        response.setData(data);
        response.setStatus(Status.SUCCESS);
        return response;
    }

    public static <T> IntegrationMessage<T> exceptionResponse(String message) {
        IntegrationMessage<T> response = new IntegrationMessage<>();

        Description desc = new Description();
        desc.setDescription(message);

        response.setStatus(Status.EXCEPTION);
        response.setDescription(desc);

        return response;
    }

    public static <T> IntegrationMessage<T> errorResponse(String message) {
        IntegrationMessage<T> response = new IntegrationMessage<>();

        Description desc = new Description();
        desc.setDescription(message);

        response.setStatus(Status.ERROR);
        response.setDescription(desc);

        return response;
    }


    @RequiredArgsConstructor
    private enum Status {
        SUCCESS("sucess"),
        ERROR("error"),
        EXCEPTION("exception");

        private final String value;
    }

    @Getter
    @Setter
    private static class Description {
        private String description;
    }
}
