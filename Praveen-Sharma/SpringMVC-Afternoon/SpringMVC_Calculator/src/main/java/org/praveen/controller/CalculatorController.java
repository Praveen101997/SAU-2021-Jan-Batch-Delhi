package org.praveen.controller;

import org.praveen.exceptions.LargeNumber;
import org.praveen.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {

    @Autowired
    private Calculator service;

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String handleCalculatorRequests (@RequestParam String firstNum, @RequestParam String secondNum,@RequestParam String operation, ModelMap model) throws Exception{
        float result = service.calculate(firstNum, secondNum , operation);
        if(result>1000)
        {
            throw new LargeNumber();
        }
        model.put("result", result);
        return "result";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String startCalculator()throws Exception{
        return "calculator";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String displayResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "result";
    }




}
