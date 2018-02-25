package Controllers;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.blog.Blog.App;

import Models.Post;
import Controllers.GroupController;
import Controllers.Email;

public class PostController {

    static Scanner s = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static List<Post> posts = new ArrayList<Post>();

    
    public static void newPost()
    {
     	Post p = new Post();
     	Email em = null;
		try {
			em = new Email();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	try {
        System.out.println( "Type the Post Title" );
        String input1 = br.readLine();
        p.setTitle(input1);
        System.out.println( "Type your post body" );
        input1 = br.readLine();
        p.setBody(input1);
        p.setDate(new Date());
        p.setCreator(App.loggedUser);
        
        
        ArrayList<String> tags = new ArrayList<String>();

        System.out.println( "Input 2 tags for your post, do it one at a time!" );
        for(int i=0;i<2;i++)
        {
            input1 = br.readLine();
        	tags.add(input1);
        }
        p.setTags(tags);
        

        
        System.out.println("Select a group to post it to " + "\n");
        App.CGroup.showGroups();
        int inpu = 0;
        try {
        inpu = s.nextInt();
        }
        catch(Throwable e)
        {
        	System.out.println("Select a valid group");
        }
        p.setGroup(App.CGroup.groups.get(inpu-1));
        
        

    	}
    	 
    	 catch(Throwable e)
    	 {
 	        System.out.println( "select an option" );
 	        newPost();

    	 }
        
        posts.add(p);
        em.newPostNotification(p, p.getGroup());
        
        
        System.out.println( "What do you want to do next? 1-Add another post 2-back to menu" );
        
    
        Integer input = new Integer(new Scanner(System.in).nextInt());
		try {
			if(input==1)
			{
	        	newPost();

			}
			
			else if (input==2)
			{
	        	App.menu();

			}
			
			else
			{
		        System.out.println( "Type a correct value ");

			}
				
			
		
       
		}
		 catch (java.util.InputMismatchException error) {
				// TODO Auto-generated catch block
			 System.out.println("Input a valid option");
			}
      
        
        
    }
    
    public static void showPosts()
    {
   	 for (int i = 0; i < posts.size(); ++i) {
	        System.out.println( "Recent Posts" );
	        System.out.println( (i+1) + "-" + posts.get(i).toStringPost() );
   	 }
   	 
        System.out.println( "What do you want to do next? 1-Add a new post 2-Order by  3-Search post 4-delete a post 5-Back to menu" );
       int input = 0;
        try {
        	 input = s.nextInt();
        	
        }
        catch(InputMismatchException i)
        {
 	        System.out.println( "Select a valid option" );

        }
       while(input!= 1 && input != 2 && input != 3)
       {
       	System.out.println( "Select a valid option 1-Add a new post 2-Order by  3-Search post 4-delete a post 5-Back to menu" );
       	input = s.nextInt();
       }
       if(input==1)
       {
       	newPost();
       }
       
       else if(input==2)
       {
    	   System.out.println("Order by 1-Newest to oldest 2-Oldest to newest 3-A to Z 4- Z to A");
    	   int input2 = s.nextInt();
    	   if(input2 == 1)
    	   {
    		   orderByNewFirst();
    	   }
    	   else if(input==2)
    	   {
    		   orderByOldFirst();
    	   }
    	   else if(input==3)
    	   {
    		   orderByAlphabet();
    	   }
    	   else if(input==4)
    	   {
    		   orderByReverseAlphabet();
    	   }
       }
       
       else if(input == 3)
       {
    	   System.out.println("Search by 1-Tag 2-Text 3-Creator 4-dates");
    	   int input3 = s.nextInt();
    	   String input4;
    	   if(input3==1)
    	   {
        	   System.out.println("Write a tag");
               input4 = new String(new Scanner(System.in).nextLine());
        	   searchTag(input4);

    	   }
    	   else if(input==2)
    	   {
        	   System.out.println("Write a part of the text");
        	   input4 = s.nextLine();
        	   searchText(input4);
        	   

    	   }
    	   else if(input==3)
    	   {
        	   System.out.println("Write the user's name");
        	   input4 = s.nextLine();
        	   searchCreator(input4);


    	   }
    	   else if(input==4)
    	   {
    		   System.out.println("Please enter the first date, format(yyyy-MM-dd)");
               String first = s.nextLine();
               System.out.println("Please enter the second date, format(yyyy-MM-dd)");
               String second = s.nextLine();
               DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               try {
                   Date dFirst = sdf.parse(first);
                   Date dSecond = sdf.parse(second);
                   ArrayList<Post> foundedposts = searchDates(dFirst, dSecond);
                   if (foundedposts.isEmpty()) {
                       System.out.println("Post between this dates no found");
                   } else {
                       for (Post post : foundedposts) {
                           post.toStringPost();
                       }
                   }
               } catch (java.text.ParseException e) {
                   System.out.println("Date format error");
               }


    	   }


       }
       else if(input==4)
       {
       	System.out.println( "which post? use post number, tpye 0 to go back" );
       	input = s.nextInt();
       	if(input != 0)
       	{
       		posts.remove(input-1);
       		System.out.println( "Post removed" );
       		App.menu();
       		
       	}
       	else
       	{
       		showPosts();
       	}
       			
       	

       }
       
       else if(input==5)
       {
       	App.menu();
       }
       

   	 
   	 

    }
    
    public static ArrayList<Post> searchTag(String tag) {
        ArrayList<Post> result = new ArrayList<Post>();
        for (Post post : posts) {
            ArrayList<String> list = post.getTags();
            for (String taglist : list){
                if (tag.equals(taglist)){
                	result.add(post);
                }
            }

        }
        return result;
    }
    
    public static ArrayList<Post> searchText(String text){
        ArrayList<Post> result = new ArrayList<Post>();
        for(Post post : posts){
            if (post.getBody().contains(text)) {
                result.add(post);
            }
        }
        return result;
    }

    public static ArrayList<Post> searchCreator(String name){
        ArrayList<Post> result = new ArrayList<Post>();
        for (Post post : posts){
            String creator = post.getCreator().getUsername();
            if (creator.equals(name)) {
                result.add(post);
            }
        }
        return result;
    }
    
    public static ArrayList<Post> searchDates(Date from, Date to){
        ArrayList<Post> result = new ArrayList<Post>();
        for(Post post : posts){
            if(post.getDate().after(from) && post.getDate().before(to)){
                result.add(post);
            }
        }
        return result;
    }
    
    public static void orderByOldFirst(){
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post post, Post post2) {
                return post.getDate().compareTo(post2.getDate());
            }
        });

    }
    public static void orderByNewFirst(){
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post post, Post post2) {
                return post2.getDate().compareTo(post.getDate());
            }
        });
    }
    public static void orderByReverseAlphabet(){
    	Collections.sort(posts, Comparator.comparing(Post::getTitle));

    	/*Collections.sort(posts,
                new Comparator<Post>()
                {
                    public int compare(Post post1, Post post2)
                    {
                        return post2.getTitle().compareTo(post1.getTitle());
                    }        
                });
*/
    	
    }
    public static void orderByAlphabet(){
    	Collections.sort(posts,
                new Comparator<Post>()
                {
                    public int compare(Post post1, Post post2)
                    {
                        return post1.getTitle().compareTo(post2.getTitle());
                    }        
                });

    }
}
