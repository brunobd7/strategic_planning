package com.dantas.strategicplanning.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// EXPLICITING DEFINE THIS CLASS LOOKUP/LISTEN ALL APPLICATION TO HANDLE ANY EXCEPTIONS
@ControllerAdvice
public class StrategicPlanningExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex,"MENSAGEM INVALIDA - CAMPOS INVALIDOS",headers,HttpStatus.BAD_REQUEST,request);
//        return handleExceptionInternal(ex,body,headers,status,request);
    }
}
