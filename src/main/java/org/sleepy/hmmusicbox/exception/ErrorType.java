package org.sleepy.hmmusicbox.exception;

public interface ErrorType {
    int getCode();
    String getMessage();
    int getHttpCode();

}
