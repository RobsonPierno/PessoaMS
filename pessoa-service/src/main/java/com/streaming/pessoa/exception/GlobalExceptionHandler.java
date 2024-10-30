package com.streaming.pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.streaming.pessoaclient.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ErrorResponseDTO handleException(NoContentException ex) {
		ErrorResponseDTO resp = new ErrorResponseDTO();
		
		resp.setErrorMessage(ex.getMessage());
		
		return resp;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponseDTO handleException(NotFoundException ex) {
		ErrorResponseDTO resp = new ErrorResponseDTO();
		
		resp.setErrorMessage(ex.getMessage());
		
		return resp;
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponseDTO handleException(RuntimeException ex) {
		ErrorResponseDTO resp = new ErrorResponseDTO();
		
		String message = "Unexpected error: " + ex.getMessage();
		resp.setErrorMessage(message);
		
		return resp;
	}
}
