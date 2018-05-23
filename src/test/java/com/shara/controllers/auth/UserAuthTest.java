/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.controllers.auth;

import com.mashape.unirest.http.JsonNode;
import static com.shara.controllers.auth.FakerValues.popLogin;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.shara.controllers.auth.FakerValues.popReg;
import static com.shara.controllers.auth.FakerValues.setObjectMapper;
import static com.shara.controllers.auth.UserAuth.register;
import com.shara.models.User;

/**
 *
 * @author mighty
 */
public class UserAuthTest {
    
    public static String _token;
    
    public UserAuthTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Now Testing");
        setObjectMapper();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Done Testing");
    }
    
    @Before
    public void setUp() {
        System.out.println("New Test");
    }
    
    @After
    public void tearDown() {
        System.out.println("Done with test");
    }
    @Test public void random(){
        
    }
    /**
     * Test of register method, of class UserAuth.
     */
//    @Test
//    public void testRegister() {
//        System.out.println("register");
//        HashMap<String, Object> userInfo = popReg();
//        User user = register(userInfo);
//        System.out.println(user.getCity());
//        assertNotNull(user);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of login method, of class UserAuth.
     */
//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        HashMap<String, Object> userInfo = popLogin();
//        User result = UserAuth.login(userInfo);
//        System.out.println(result.getApiToken());
//        assertNotNull(result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of logout method, of class UserAuth.
//     */
//    @Test
//    public void testLogout() {
//        System.out.println("logout");
//        User expResult = null;
//        User result = UserAuth.logout();
//        assertNotNull(result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
    
}
