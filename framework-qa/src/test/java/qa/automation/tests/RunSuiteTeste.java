package qa.automation.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import junit.framework.TestSuite;
import qa.automation.core.CustomExecutionListener;

import org.junit.runner.*;

public class RunSuiteTeste {
    static JUnitCore junitCore;
    static Class<?> testClasses;

    public static void main(String[] args) {
        System.out.println("Running Junit Test Suite.");
        junitCore = new JUnitCore();
        junitCore.addListener(new CustomExecutionListener());

        Result result = junitCore.run(RestContaTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Successful: " + result.wasSuccessful() + " run " + result.getRunCount() + " tests");
    }
}
