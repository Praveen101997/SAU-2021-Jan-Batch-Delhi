package org.praveen.exceptions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class ByZeroDivision extends Exception{

    public ByZeroDivision()
    {
        super("Divide by Zero");
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = ByZeroDivision.class)
    public @ResponseBody
    HashMap<String, String> handleError(HttpServletRequest req, Exception exception) {
        HashMap<String,String> obj=new HashMap<>();
        obj.put("Operation","/");
        obj.put("Message","Divide By Zero");
        return obj;
    }
}
