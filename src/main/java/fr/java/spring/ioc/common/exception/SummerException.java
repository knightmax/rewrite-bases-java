package fr.java.spring.ioc.common.exception;

public class SummerException extends RuntimeException {

    public SummerException(String msg) {
        super(msg);
    }

    public SummerException(String msg, Exception e) {
        super(msg, e);
    }
}
