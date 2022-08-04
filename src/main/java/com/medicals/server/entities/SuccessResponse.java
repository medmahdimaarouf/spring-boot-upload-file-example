package com.medicals.server.core.entities;

import java.io.Serializable;

public class SuccessResponse<T> extends Response implements Serializable {
    private T data;

    public SuccessResponse(T data) {
        this.success = true;
        this.data = data;
    }

    public SuccessResponse(T data, String message) {
        this(data);
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


/*
public class ResponseHelper<T> {
    public  ResponseEntity<ErrorResponse<T>> error(T error,HttpStatus status){
        return new ResponseEntity<ErrorResponse<T>>(new ErrorResponse<T>(error),status);
    }

    public  ResponseEntity<SuccessResponse<T>> success(T data,HttpStatus status){
        return new ResponseEntity<SuccessResponse<T>>(new SuccessResponse<T>(data),status);
    }
}
*/
/*
{
    Success:boolean,
    data:T
},
{
    success:false,
    error:T
}
 */
