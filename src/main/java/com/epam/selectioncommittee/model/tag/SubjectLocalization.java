package com.epam.selectioncommittee.model.tag;

import com.epam.selectioncommittee.model.entity.Subject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SubjectLocalization extends SimpleTagSupport {

    private Subject subject;


    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (getJspContext().findAttribute("lang").equals("ru")) {
            out.write(subject.getNameRU());
        } else {
            out.write(subject.getNameEN());
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
