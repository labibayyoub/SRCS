package beans;

import javax.ejb.LocalBean;
import javax.ejb.*;

/**
 * Session Bean implementation class Counter
 */
@Stateful
@LocalBean
public class Counter implements CounterRemote {
	
	private int cpt;
    /**
     * Default constructor. 
     */
    public Counter() {
        
    }
    

	public Counter(int cpt) {
		super();
		this.cpt = cpt;
	}


	@Override
	public int getValue() {
		return cpt;
	}

	@Override
	public void increment() {
		 ++cpt;
	}

	@Override
	public void decrement() {
		--cpt;
	}

}
