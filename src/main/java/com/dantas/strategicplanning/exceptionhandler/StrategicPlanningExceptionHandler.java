package com.dantas.strategicplanning.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

// EXPLICITING DEFINE THIS CLASS LOOKUP/LISTEN ALL APPLICATION TO HANDLE ANY EXCEPTIONS
@ControllerAdvice
public class StrategicPlanningExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String userMessage = messageSource.getMessage("invalid.message",null,LocaleContextHolder.getLocale());
        String causeMessage = Optional.ofNullable(ex.getCause()).orElse(ex).toString();

        return handleExceptionInternal(ex,new ApiErro(causeMessage,userMessage),headers,HttpStatus.BAD_REQUEST,request);
//        return handleExceptionInternal(ex,body,headers,status,request);
    }

    //TODO HANDLE OTHERS COMMONS EXCEPTION 'EMPTY DATA ACCESS' NOT FIND ON GETS
    // AND 'INTEGRITY' TO DELETE METHODS ENVOLVES FK IN RESOURCES

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ApiErro> errosList = mapTrackedErros(ex.getBindingResult());

        return handleExceptionInternal(ex, errosList , headers, HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){

        String userMessage = messageSource.getMessage("resource.not-found",null,LocaleContextHolder.getLocale());
        String causeMessage = ex.toString();

        List<ApiErro> erros = Arrays.asList(new ApiErro(causeMessage,userMessage));

        return  handleExceptionInternal(ex,erros,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }


    private List<ApiErro> mapTrackedErros(BindingResult bindingResult) {

        List<ApiErro> trackedErros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()){

            String userMessage = messageSource.getMessage(fieldError,LocaleContextHolder.getLocale());
            String causeMessage = fieldError.toString();

            trackedErros.add( new ApiErro(causeMessage, userMessage));

        }

        return trackedErros;
    }


    //AUX CLASS
    public static class ApiErro{

        String causeErroMessage;
        String userErroMessage;


        public ApiErro(String causeErroMessage) {
            this.causeErroMessage = causeErroMessage;
        }

        public ApiErro(String causeErroMessage, String userErroMessage) {
            this.causeErroMessage = causeErroMessage;
            this.userErroMessage = userErroMessage;
        }

        public String getCauseErroMessage() {
            return causeErroMessage;
        }

        public void setCauseErroMessage(String causeErroMessage) {
            this.causeErroMessage = causeErroMessage;
        }

        public String getUserErroMessage() {
            return userErroMessage;
        }

        public void setUserErroMessage(String userErroMessage) {
            this.userErroMessage = userErroMessage;
        }
    }
}
