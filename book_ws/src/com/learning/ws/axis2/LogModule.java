package com.learning.ws.axis2;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisModule;
import org.apache.axis2.description.AxisDescription;
import org.apache.neethi.Assertion;
import org.apache.neethi.Policy;

public class LogModule implements org.apache.axis2.modules.Module {

    public void init(ConfigurationContext configContext, AxisModule module) throws AxisFault {
        //Initialize the module
    }

    public void shutdown(ConfigurationContext configurationContext) throws AxisFault {
        //End of module processing
    }

    public void engageNotify(AxisDescription axisDescription) throws AxisFault {
    }

    public void applyPolicy(Policy policy, AxisDescription axisDescription) throws AxisFault {
    }

    public boolean canSupportAssertion(Assertion assertion) {
        return true;
    }

}
