/**
 * @auther Rakesh
 * @time Mar 11, 2017
 */

package com.rkumbhare.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rkumbhare.myapp.vo.ClientError;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ClientError> accessDeniedExceptionHandler(AccessDeniedException e) {
		ClientError error = new ClientError(HttpStatus.FORBIDDEN, "Access Denied",
				"You dont have sufficient privillage to access this resource");
		ResponseEntity<ClientError> errorResponse = new ResponseEntity<ClientError>(error, HttpStatus.FORBIDDEN);
		return errorResponse;
	}

}
