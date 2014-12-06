package cn.zy.commons.webdev.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RESTful response transfer object.
 *
 * @author zy
 * @version 2.0.0
 * @since 2.0.1
 */
public class RestResponse {

	/**
	 * Response status code.
	 *
	 * @see cn.videoworks.commons.webdev.constant.ResponseStatusCode
	 */
	private int statusCode;

	/** Response status message. */
	private String message;

	/** Response header. */
	private Map<String, Object> header;
	
	private List<Map<String,Object>> errors;

	/** Response body. */
	private Map<String, Object> body;


	public RestResponse() {
		this.header = new HashMap<>();
		this.body = new HashMap<>();
		this.errors = new ArrayList<>();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getHeader() {
		return header;
	}

	public Map<String, Object> getBody() {
		return body;
	}


	public List<Map<String, Object>> getErrors() {
		return errors;
	}

}
