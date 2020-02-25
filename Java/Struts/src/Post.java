
public class Post {
	private String postedBy;
	private String postee;
	private String content;
	
	public Post(String postedBy, String content) {
		super();
		this.postedBy = postedBy;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getPostee() {
		return postee;
	}
	public void setPostee(String postee) {
		this.postee = postee;
	}

}
