package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Models.Post;
import Models.User;
import Models.Group;

public class Email 
    {
	File file = new File("emails.txt");
    FileWriter fileWriter = new FileWriter(file);
    public Email() throws java.io.IOException {
    }

    public void newPostNotification(Post post,Group group)
    {

        String to = "";
        String subject = "New Post in the Group:  " + group.getName();
        String body= "\n" + "Title: "+post.getTitle()+"\n" +"Text:" + "\n" +post.getBody()+"\n";
        for (User user : group.getMembers()){
            to = to + user.getEmail() + ",";
        }
        to = to.substring(0,to.length()-1);
        try 
        {
            fileWriter.write("TO:\t" + to + "\nSubject:\t" + subject + "\n" +"Text:" + body );
        } catch (IOException e)
        {
        	
        }

    }
    

    public void flush(){
        try 
        {
            fileWriter.flush();
        } catch (IOException e) 
        {
        	
        }
    }
}
