package cn.zy.commons.webdev.http;

import java.util.HashMap;
import java.util.Map;

/**
 * RESTful response transfer object.
 *
 * @author zy
 * @version 1.0.0
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

	/** Response body. */
	private Map<String, Object> body;

	/**
	 * Response data.<br/>
	 * NOTICE: This field is deprecated since 2.0.0.
	 * Using {@link cn.videoworks.commons.webdev.http.RestResponse#header}
	 * and {@link cn.videoworks.commons.webdev.http.RestResponse#body} please.
	 *
	 * @deprecated This field is not recommended.
	 * Instead of {@link cn.videoworks.commons.webdev.http.RestResponse#header}
	 * and {@link cn.videoworks.commons.webdev.http.RestResponse#body}.
	 */
	@Deprecated
	private Map<String, Object> data;

	public RestResponse() {
		this.header = new HashMap<>();
		this.body = new HashMap<>();
		data = body;
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

	@Deprecated
	public Map<String, Object> getData() {
		return data;
	}
}
