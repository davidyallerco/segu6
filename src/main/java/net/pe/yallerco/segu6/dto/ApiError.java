package net.pe.yallerco.segu6.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApiError implements Serializable {

    private String backendMessage;

    private String message;
    
    private String url;
    
    private String method;
    
    private int httpCode;

    private LocalDateTime timestamp;

	public String getBackendMessage() {
		return backendMessage;
	}

	public void setBackendMessage(String backendMessage) {
		this.backendMessage = backendMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
   
    
}