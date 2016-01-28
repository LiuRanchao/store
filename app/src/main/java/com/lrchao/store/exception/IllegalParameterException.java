package com.lrchao.store.exception;

/**
 * Description: 参数非法异常
 *
 * @author liuranchao
 * @date 15/12/22 上午10:39
 */
public class IllegalParameterException extends RuntimeException{

    public IllegalParameterException(String detailMessage) {
        super(detailMessage);
    }
}
