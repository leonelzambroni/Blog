package com.blog.Blog;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Controllers.GroupController;
import Controllers.PostController;
import Controllers.UserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Models.Post;
import Models.User;

/**
 * Hello world!
 *
 */
public class App 
{
	public static PostController Cpost = new PostController();
	static UserController Cuser = new UserController();
	public static GroupController CGroup = new GroupController();
    static Boolean exit = false;
	static Scanner s = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static List<Post> posts = new ArrayList<Post>();
	public static User loggedUser = null;


    public static void main( String[] args )
    {
    	if(loggedUser==null)
    	{
    		UserController.newUser();
    	}
		if(CGroup.groups.size()==0)
		{
			System.out.println( "Input a name for a new group" );
	        String name = new Scanner(System.in).nextLine();
			
			CGroup.newGroup(loggedUser,name );		
		}
    	menu();
    			
    }
    		public static void menu()  
		{
    			while(exit!=true)
    			{
    		        int input = 0;
    		        		
    				
    			
    				
    		        System.out.println( "Select an option" );
    		        System.out.println( "1-New Post" );
    		        System.out.println( "2-Show Recent Posts" );
    		        System.out.println( "3-New Group");
    		        System.out.println( "4-Exit" );
    		        
    		        try {
    		        	if(s.hasNextInt())
    		        	{
    		        		input = s.nextInt();
	        	   

	        	
	        	
	        	if(input == 1)	        		
	        	{   
	        		
	        	    PostController.newPost();   
	        	        	
	        	}
	        	else  if (input == 2)
	        	{
	        		PostController.showPosts();	        		
	        	}
	        	
	        	else if(input == 3)
	        	{
	        		
	        		System.out.println("input a name for a new group");
	        		String name = new Scanner(System.in).nextLine();
	    			
	    			CGroup.newGroup(loggedUser,name );			        	
	    		}
	        	
	        	else if(input==4)
	        	{
	        		exit=true;
	        	}
	        	
	        	else
	        	{
	        		System.out.println( "Ingrese 1 o 2" );
		               
	        	}
	        	        
	        	        

	        }    
	        	     	  	           
		
		
        	}catch(java.util.InputMismatchException error) {
        		System.out.println( "Ingrese un valor valido" );
 	               continue;

    				
		}
}
    			   			
        		System.out.println( "Hasta pronto!" );
        		System.exit(0);


		}
        
         
        
         
         

        
        

    }
