package Models;

import java.util.ArrayList;

public class Group {
	
	String name;
    ArrayList<User> members;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	public Group(String name) {
		this.name = name;
		this.members = new ArrayList<User>();
		
	}
	
	public void addMember(User user,ArrayList<User> initialMember)
	{
		initialMember.add(user);
	}
	
	
	public String toStringGroup()
	{
		return ("Name: " + name + " Members: " + members.size());
	}
	

}
