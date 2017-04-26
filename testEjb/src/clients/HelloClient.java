package clients;





import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.SayHelloRemote;

public class HelloClient {
	public static void main(String[] args) throws NamingException  {
		
		Context con = new InitialContext(); 
		SayHelloRemote bean = (SayHelloRemote) con.lookup("java:global/HelloApplication/HelloEJB/SayHello!beans.SayHelloRemote") ;
		System.out.println(bean.hello("world"));
	}

}
