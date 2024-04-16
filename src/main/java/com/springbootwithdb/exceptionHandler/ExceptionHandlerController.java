package com.springbootwithdb.exceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	public ProblemDetail ExceptionhanderMethod(Exception ex) {
		ProblemDetail pb = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		pb.setTitle("Not Found Exception");
		pb.setDetail(ex.getMessage());
		return pb;
		
	}
	@ExceptionHandler(RecordNotFoundCustomeExp.class)
	public ProblemDetail ExceptionhanderMethodCustom(RecordNotFoundCustomeExp erx) {
		ProblemDetail pb = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		pb.setTitle("Not Found ");
		pb.setDetail(erx.getMessage());
		return pb;
		
	}

}
