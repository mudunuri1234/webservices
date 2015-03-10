package com.learning.ws.axis2.axiom;

import org.apache.axiom.om.OMElement;

public interface GradeManagerService {

    OMElement getSubjects(OMElement gradeElement) throws Exception;

}
