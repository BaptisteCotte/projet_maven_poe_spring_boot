package fr.formation.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)   {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
        return new ModelAndView("redirect:/error/page");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
        return new ModelAndView("redirect:/error/page");
    }
}