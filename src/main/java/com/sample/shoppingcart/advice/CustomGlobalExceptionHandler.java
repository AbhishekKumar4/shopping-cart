package com.sample.shoppingcart.advice;

import com.sample.shoppingcart.exception.ProductNotFoundException;
import com.sample.shoppingcart.exception.ShoppingCartNotFoundException;
import com.sample.shoppingcart.exception.model.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(value = {ShoppingCartNotFoundException.class})
    public ResponseEntity<Object> handleCartNotFoundException(ShoppingCartNotFoundException ex) {
        GlobalException globalException = new GlobalException();
        globalException.setMessage(ex.getMessage());
        globalException.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Object>(globalException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
        GlobalException globalException = new GlobalException();
        globalException.setMessage(ex.getMessage());
        globalException.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Object>(globalException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherException(Exception ex) {
        GlobalException globalException = new GlobalException();
        globalException.setMessage(ex.getMessage());
        globalException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<Object>(globalException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
