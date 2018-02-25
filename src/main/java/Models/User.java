package Models;

import java.util.ArrayList;

public class User {
	String username;
	String email;
    ArrayList<Group> groups;
    
    
    public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(String username,String email)
    {
    	this.username = username;
    	this.email = email;
        this.groups = new ArrayList<Group>();

    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	
	public void addgroup(Group group){
        this.groups.add(group);
    }
    
    


}
