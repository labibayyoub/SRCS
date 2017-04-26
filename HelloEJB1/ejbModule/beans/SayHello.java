package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SayHello
 */
@Stateless
@LocalBean
public class SayHello implements SayHelloRemote {

    /**
     * Default constructor. 
     */
    public SayHello() {
    }

	@Override
	public String hello(String a) {
		return "hello"+a;
	}

    
}
