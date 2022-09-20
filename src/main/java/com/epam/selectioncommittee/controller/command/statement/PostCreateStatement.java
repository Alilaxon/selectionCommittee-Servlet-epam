package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.mapper.StatementFormMapper;
import com.epam.selectioncommittee.model.dto.StatementForm;
import com.epam.selectioncommittee.model.exception.UserAlreadyRegisteredException;
import com.epam.selectioncommittee.model.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostCreateStatement implements Command {

    private static final Logger log = LogManager.getLogger(PostCreateStatement.class);
    StatementService statementService;

    public PostCreateStatement(StatementService statementService) {

        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        StatementForm statementForm = StatementFormMapper.mapper(request);

        log.info("try to create new statement");
       try {
           statementService.createStatement(statementForm);

       } catch (UserAlreadyRegisteredException exception){

           log.info(exception);

       }

        //TODO

        return "redirect:/faculties";
    }
}
