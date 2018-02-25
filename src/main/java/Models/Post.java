package Models;

import java.util.ArrayList;
import java.util.Date;



public class Post {
	private String title;
	private String body;
	private Date date;
    ArrayList<String> tags;
    User creator;
	Group group;

    public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	public Post(String title,String body, Date date, ArrayList<String> tags, User creator,Group group) {
		this.title = title;
		this.body = body;
		this.date = date;
		this.tags = tags;
		this.creator = creator;
		this.group = group;
		
				
	}
	
	public String toStringUser()
	{
		String respuesta = creator.getUsername();
		return respuesta;
	}
	
	public String toStringGroup()
	{
		String respuesta = group.getName();
		return respuesta;
	}
	public String toStringPost()
	{
		return(title + "\n" + toStringUser() + "\n"  +"Group:" + toStringGroup() + "\n" + body + "\n" +"tags: " + tags.get(0) + "," + tags.get(1) + "\n" + date);
	}
	
	public String toStringTitle()
	{
		return(title);
	}
	

}
