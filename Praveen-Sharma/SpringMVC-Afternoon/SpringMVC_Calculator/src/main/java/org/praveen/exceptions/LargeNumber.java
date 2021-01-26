package org.praveen.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class LargeNumber extends Exception{

    public LargeNumber(){
        super("Result is too Large to display");
    }

    @ExceptionHandler(value = LargeNumber.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mv=new ModelAndView();
        System.out.println(exception);
        mv.addObject("exception",exception);
        mv.addObject("url",req.getRequestURL());
        mv.setViewName("exceptionview");
        return mv;
    }
}
