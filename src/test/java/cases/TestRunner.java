package cases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mighty
 */

import com.shara.controllers.auth.UserAuthTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(UserAuthTest.class);
        result.getFailures().forEach((failure) -> {
            System.out.println(failure.toString());
        });
        System.out.println(result.wasSuccessful());
    }
}
