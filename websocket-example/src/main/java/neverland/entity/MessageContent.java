package neverland.entity;

public class MessageContent {

	private int contentId;
	private String data;
	
	public MessageContent() {
	}
	
	public MessageContent(int contentId, String data) {
		this.contentId = contentId;
		this.data = data;
	}
	
	public int getContentId() {
		return contentId;
	}
	
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return "ID: " + this.contentId + ", DATA: " + this.data;
	}
}
