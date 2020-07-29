package com.xc.justforjoy.tx.exception;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class UserAccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserAccountException() {
		super();
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountException(String message) {
		super(message);
		System.out.println("余额不足");
	}

	public UserAccountException(Throwable cause) {
		super(cause);
	}

}
