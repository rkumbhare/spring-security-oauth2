/**
 * @auther Rakesh
 * @time Feb 12, 2017
 */

package com.rkumbhare.myapp.vo;

import org.springframework.http.HttpStatus;

public class ClientError {
	private HttpStatus status;
	private String error;
	private String description;

	public ClientError(HttpStatus status, String error, String description) {
		this.status = status;
		this.description = description;
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
