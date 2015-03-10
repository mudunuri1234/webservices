package com.learning.ws.jaxws.composite;

import com.learning.util.XMLBuilder;

import javax.jws.WebService;

@WebService(name = "GradeManagerService",
            endpointInterface = "com.learning.ws.jaxws.composite.GradeManager")
public class GradeManagerImpl implements GradeManager {

    public String getGradeSubjects(Integer grade) {
        return XMLBuilder.getAllSubjects(grade);
    }

}
