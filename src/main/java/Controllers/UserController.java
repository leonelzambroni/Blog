package Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.blog.Blog.App;

import Models.User;
import Models.Group;
public class UserController {
	static Scanner s = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static List<User> users = new ArrayList<User>();
	
	public static void newUser()
	{
		User u = new User();
	        System.out.println( "Input your username" );
	        String input = new Scanner(System.in).nextLine();
	        u.setUsername(input);
	        System.out.println( "Input your email" );
	        u.setEmail(new Scanner(System.in).nextLine());  
	        
	        users.add(u);
	        App.loggedUser = u;

	        
	        

	       
	        
        
			}
	
	
	
	public void addGroup(Group group)
	{
		
		App.loggedUser.addgroup(group);     
				
	}
			
		}
	

	



