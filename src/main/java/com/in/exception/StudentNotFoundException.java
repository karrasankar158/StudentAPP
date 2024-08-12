package com.in.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class StudentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String message;
	
	private Integer statusCode;	
}
