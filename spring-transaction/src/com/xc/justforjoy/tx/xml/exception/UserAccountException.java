package com.xc.justforjoy.tx.xml.exception;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class UserAccountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message) {
		super(message);
		System.out.println("余额不足");
	}

	public UserAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
