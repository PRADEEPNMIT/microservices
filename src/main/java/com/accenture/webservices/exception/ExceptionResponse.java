package com.accenture.webservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date dateStamp;
	
	private String message;
	
	private String details;

	public ExceptionResponse(Date dateStamp, String message, String details) {
		super();
		this.dateStamp = dateStamp;
		this.message = message;
		this.details = details;
	}

	public Date getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [dateStamp=" + dateStamp + ", message=" + message + ", details=" + details
				+ ", getDateStamp()=" + getDateStamp() + ", getMessage()=" + getMessage() + ", getDetails()="
				+ getDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
