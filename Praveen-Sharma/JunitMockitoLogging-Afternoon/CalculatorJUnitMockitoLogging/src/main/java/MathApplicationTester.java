
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;



//@runWith attaches a runner with the test class to initialize the test data
//To process annotations, we can use the built-in runner MockitoJUnitRunner

//Junit Tester Function
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    private MathApplication mathApplication;
    private CalculatorService calcService;
    private CalculatorImp calculatorImp;
    private static final Logger logger= LogManager.getLogger(MathApplication.class.getName());

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
        calculatorImp = new CalculatorImp();
    }
    @Test
    public void testAddAndSubtract(){
        //add the behavior to add number
        when(calcService.add(20.0,10.0)).thenReturn(30.0);


        //add the behavior to subtract number
        when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0,10.0),10.0,0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0,10.0),30.0,0);

        //verify call to add method to be completed within 100ms
        verify(calcService,timeout(100)).add(20.0,10.0);

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given timeframe
        verify(calcService,timeout(100).times(1)).subtract(20.0,10.0);
    }

    @Test
    public void testAdd() {
        int a = 15;
        int b = 20;
        int expectedResult = 35;
        // Act
        double result = calculatorImp.add(a, b);
        // Assert
        Assert.assertEquals(expectedResult, result,0);

        logger.debug("Test ADD | "+"Expected Result : "+expectedResult +" | "+"Actual Result : "+result);
    }

    @Test
    public void testSubtract() {
        int a = 25;
        int b = 20;
        int expectedResult = 5;
        double result = calculatorImp.subtract(a, b);
        Assert.assertEquals(expectedResult, result,0);
        logger.debug("Test SUB | "+"Expected Result : "+expectedResult +" | "+"Actual Result : "+result);
    }

    @Test
    public void testMultiply() {
        int a = 10;
        int b = 25;
        long expectedResult = 250;
        double result = calculatorImp.multiply(a, b);
        Assert.assertEquals(expectedResult, result,0);
        logger.debug("Test MULTIPLY | "+"Expected Result : "+expectedResult +" | "+"Actual Result : "+result);
    }

    @Test
    public void testDivide() {
        int a = 56;
        int b = 10;
        double expectedResult = 5.6;
        double result = calculatorImp.divide(a, b);
        Assert.assertEquals(expectedResult, result, 0.00005);
        logger.debug("Test DIVIDE | "+"Expected Result : "+expectedResult +" | "+"Actual Result : "+result);
    }
}
