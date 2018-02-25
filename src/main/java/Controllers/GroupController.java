package Controllers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.blog.Blog.App;

import Models.Group;
import Models.User;
public class GroupController {
	
	static Scanner s = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static List<Group> groups = new ArrayList<Group>();
	
	
	public static void newGroup(User user, String name)
	{
		
		Group g = new Group();
		ArrayList<User> initialMember = new ArrayList<User>();
		try {
	        	g.setName(name);
	        	g.addMember(user,initialMember);
	        	g.setMembers(initialMember);
	        	
	        	groups.add(g);	    	
	        	}
	    	 
	    	 catch(Throwable e)
	    	 {
	 	        System.out.println( "select an option" );

	    	 }
	        
	        
	}
	
	public static void showGroups() 
	{	
		System.out.println( "Groups" );
		for (int i = 0; i < groups.size(); ++i) {
	        System.out.println( (i+1) + "-" + groups.get(i).toStringGroup() );
   	 }	 
     
       	

       
       

   	 
   	 

    
	}


}
