
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.mockito.Mockito.mock;

//TestCase Runner
public class TestRunner {

    private static final Logger logger=LogManager.getLogger(TestRunner.class.getName());

    public static void main(String[] args){

        Result result = JUnitCore.runClasses(MathApplicationTester.class);

        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
            logger.error("Failed : "+failure.toString());
        }
        logger.info("Success : "+result.wasSuccessful());
        System.out.println("Success : "+result.wasSuccessful());
        
    }
}
