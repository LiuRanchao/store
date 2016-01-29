package com.lrchao.store.exception;

/**
 * Description: 初始化异常
 *
 * @author liuranchao
 * @date 15/12/22 上午10:39
 */
public class InitializationException extends RuntimeException{

    public InitializationException(String detailMessage) {
        super(detailMessage);
    }
}
