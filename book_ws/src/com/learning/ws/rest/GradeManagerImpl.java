package com.learning.ws.rest;

import com.learning.util.XMLBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Nov 21, 2011
 * Time: 8:30:18 PM
 */
public class GradeManagerImpl implements GradeManager {

    public String getGrades() {
        return XMLBuilder.getAllGrades();
    }

    public String getGradeSubjects(Integer grade) {
        return XMLBuilder.getAllSubjects(grade);
    }

    public String getSubjectTopics(Integer grade, String subject) {
        return XMLBuilder.getAllTopics(grade, subject);
    }

    public String getTopicContent(Integer grade, String subject, String topic) {
        return XMLBuilder.getTopicContent(grade, subject, topic);
    }

}
