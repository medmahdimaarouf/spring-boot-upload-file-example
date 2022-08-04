package com.medicals.server.core.utils;

import com.medicals.server.core.entities.ErrorResponse;
import com.medicals.server.core.entities.Response;
import com.medicals.server.core.entities.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

public class ResponseFactory<T> {
    public static ResponseEntity<Response> error(String error) {
        return new ResponseEntity<Response>(new ErrorResponse(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> error(String error, String message) {
        return new ResponseEntity<Response>(new ErrorResponse(error, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> error(String error, String message, HttpStatus status) {
        return new ResponseEntity<Response>(new ErrorResponse(error, message), status);
    }

    public static ResponseEntity<Response> error(String error, HttpStatus status) {
        return new ResponseEntity<Response>(new ErrorResponse(error), status);
    }

    public static ResponseEntity<Response> error(Exception exception) {
        return new ResponseEntity<Response>(new ErrorResponse(exception.getClass().getSimpleName()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> error(Exception exception, String message) {
        return new ResponseEntity<Response>(new ErrorResponse(exception.getClass().getSimpleName(), message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> error(Exception exception, String message, HttpStatus status) {
        return new ResponseEntity<Response>(new ErrorResponse(exception.getClass().getSimpleName(), message), status);
    }

    public static ResponseEntity<Response> error(Exception exception, HttpStatus status) {
        return new ResponseEntity<Response>(new ErrorResponse(exception.getClass().getSimpleName()), status);
    }

    public static <T> ResponseEntity<Response> success(T data) {
        return new ResponseEntity<Response>(new SuccessResponse<T>(data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<Response> success(T data, String message) {
        return new ResponseEntity<Response>(new SuccessResponse<T>(data, message), HttpStatus.OK);
    }

    public static <T> ResponseEntity<Response> success(T data, String message, HttpStatus status) {
        return new ResponseEntity<Response>(new SuccessResponse<T>(data, message), status);
    }

    public static <T> ResponseEntity<Response> success(T data, HttpStatus status) {
        return new ResponseEntity<Response>(new SuccessResponse<T>(data), status);
    }
}
