/**
 * 
 */
package com.albert.wechat.exceptions;

/** 
* @ClassName: ServiceException 
* @Description: 业务成异常
* @author albert
* @date 2018年2月2日 上午9:43:07 
*  
*/
public class ServiceException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6174745763250180374L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
        super(message);
    }
	public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
	public ServiceException(Throwable cause) {
	        super(cause);
	}
	protected ServiceException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
