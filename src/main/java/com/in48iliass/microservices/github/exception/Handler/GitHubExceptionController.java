package com.in48iliass.microservices.github.exception.Handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GitHubExceptionController {
    @ExceptionHandler(GitHubRestTemplateErrorHandler.CustomException.class)
    public ResponseEntity<String> appBusinessException(GitHubRestTemplateErrorHandler.CustomException ume) {

        return ResponseEntity.badRequest().body(ume.getLocalizedMessage());
    }
}