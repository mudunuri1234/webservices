package com.learning.ws.axis2.axiom;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class GradeManagerServiceImpl implements GradeManagerService {

    public OMElement getSubjects(OMElement gradeElement) throws Exception {
      System.out.println("---------- gradeElement ---------" + gradeElement);
      OMElement element = gradeElement.getFirstElement();
      Integer grade = new Integer(element.getText()).intValue();
      System.out.println("----- grade -----" + grade);  
      switch(grade) {
        case 9:
            return getOMElement();
        case 8:
            return getOMElement();
        default:
           return getOMElement();
      }
    }

    private OMElement getOMElement() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://jaxws.axis2.ws.learning.com", "ns");
        OMElement method = fac.createOMElement("getSubjectsResponse", omNs);
        //wraps the output parameter into <subject1/> element
        OMElement value1 = fac.createOMElement("subject1", omNs);
        //Sending output value as "Mathematics" for subject1
        value1.addChild(fac.createOMText(value1, "Mathematics"));
        OMElement value2 = fac.createOMElement("subject2", omNs);
        value2.addChild(fac.createOMText(value2, "Reading"));
        OMElement value3 = fac.createOMElement("subject3", omNs);
        value3.addChild(fac.createOMText(value3, "Music and ART"));
        OMElement value4 = fac.createOMElement("subject4", omNs);
        value4.addChild(fac.createOMText(value4, "Computer Basics"));
        method.addChild(value1);
        method.addChild(value2);
        method.addChild(value3);
        method.addChild(value4);

        return method;
    }

}
