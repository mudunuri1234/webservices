package com.learning.ws.jaxws;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Dec 25, 2011
 * Time: 7:09:02 AM
 */
public class EmployeeFault extends Exception {

    public static final long serialVersionUID = 12324835835L;

    public EmployeeFault() {
        super();
    }

    public EmployeeFault(String message) {
        super(message);
    }

    public EmployeeFault(String message, Throwable cause) {
        super(message, cause);
    }

}
