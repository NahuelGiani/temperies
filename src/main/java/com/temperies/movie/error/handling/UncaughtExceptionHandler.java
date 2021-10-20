package com.temperies.movie.error.handling;

import java.util.Stack;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UncaughtExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		return buildResponse(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex));
	}

	@ExceptionHandler(SQLErrorException.class)
	protected ResponseEntity<Object> handleSQLError(SQLErrorException ex) {
		return buildResponse(new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), getThrowableCause(ex.getCause())));
	}
	
	private ResponseEntity<Object> buildResponse(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
    private static String getThrowableCause(Throwable exception) {
        final Stack<Throwable> exceptionStack = new Stack<>();
        while (exception != null && !exceptionStack.contains(exception)) {
            exceptionStack.push(exception);
            exception = exception.getCause();
        }

        final StringBuilder errorDescription = new StringBuilder();
        while (!exceptionStack.isEmpty()) {
            final Throwable cause = exceptionStack.pop();
            if (errorDescription.length() > 0) {
                errorDescription.append(" --> ");
            }
            errorDescription.append(cause.getLocalizedMessage());
        }
        return errorDescription.toString();
    }

}