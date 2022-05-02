package edu.unlv.mis768.chernobylSam;

import edu.unlv.mis768.Model.Provider;
import edu.unlv.mis768.Model.User;

public class UserController {

    // Define objects
    
    User user;
    protected Provider provider;
    
    
    public void initializeUser(User u) {
    	user = u;
    	System.out.println("[6]User Passed to patient Window");
    	
    }
    
    public void initializeProvider(Provider p) {
    	System.out.println("[9]Provider at initialize Provider: " + p);
    	provider = p;
    	System.out.println("Provider Passed to Provider Window");
    }
	
}
