package cn.zy.commons.webdev.constant;

/**
 * 响应状态码常量，内容参考HTTP状态码定义。
 *
 * @author zy
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ResponseStatusCode {

	/** 请求处理成功。 */
	public static final int OK = 200;

	/** 请求参数有误。 */
	public static final int BAD_REQUEST = 400;

	/** 身份认证失败。 */
	public static final int UNAUTHORIZED = 401;

	/** 资源不可用。 */
	public static final int FORBIDDEN = 403;

	/** 无法找到指定位置的资源。 */
	public static final int NOT_FOUND = 404;

	/** 请求资源和当前冲突。 */
	public static final int CONFLICT = 409;

	/** 请求处理失败，服务器异常。 */
	public static final int INTERNAL_SERVER_ERROR = 500;
}