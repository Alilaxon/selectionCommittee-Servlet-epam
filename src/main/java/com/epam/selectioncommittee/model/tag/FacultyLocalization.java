package com.epam.selectioncommittee.model.tag;

import com.epam.selectioncommittee.model.entity.Faculty;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class FacultyLocalization extends SimpleTagSupport {

    private Faculty faculty;


    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (getJspContext().findAttribute("lang").equals("ru")) {
            out.write(faculty.getFacultyNameRU());
        } else {
            out.write(faculty.getFacultyName());
        }
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
