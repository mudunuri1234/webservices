package com.learning.ws.axis2;

import org.apache.axis2.handlers.AbstractHandler;
import org.apache.axis2.AxisFault;
import org.apache.axis2.engine.Handler;
import org.apache.axis2.context.MessageContext;

public class LogHandler extends AbstractHandler implements Handler {

    public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {
        System.out.println("-------- logging the invoke message ---------");
        System.out.println("------ ws action is ------" + msgContext.getWSAAction());
        System.out.println(msgContext.getEnvelope().toString());
        return InvocationResponse.CONTINUE;
    }

    public void revoke(MessageContext msgContext) {
        System.out.println("-------- logging the revoke message ---------");
         System.out.println(msgContext.getEnvelope().toString());
    }

}
