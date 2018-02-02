/**
 * 
 */
package com.albert.wechat.exceptions;

/** 
* @ClassName: WeixinMpException 
* @Description: 其他异常
* @author albert
* @date 2018年2月2日 上午9:43:07 
*  
*/
public class WeixinMpException extends RuntimeException {

	private static final long serialVersionUID = -386017656641123180L;
	/**
	 * 
	 */
	public WeixinMpException() {
		super();
	}
	public WeixinMpException(String message) {
        super(message);
    }
	public WeixinMpException(String message, Throwable cause) {
        super(message, cause);
    }
	public WeixinMpException(Throwable cause) {
	        super(cause);
	}
	protected WeixinMpException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
