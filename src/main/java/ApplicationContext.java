
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ruben.impa
 */
public class ApplicationContext {
    
    public static void main( String[] args ) throws Exception {
    	new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
