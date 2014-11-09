package projectBoard.bean;

import org.springframework.stereotype.Component;

@Component
public class ProjectBoardDTO {
	private int seq;
	private String id;
	private String subject;
	private String content;
	private int startmoney;
	private int endmoney;
	private int hit;
	private String image1;
	private String logtime;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStartmoney() { return startmoney; }
	public void setStartmoney(int startmoney) {
		this.startmoney = startmoney;
	}
	public int getEndmoney() {
		return endmoney;
	}
	public void setEndmoney(int endmoney) {
		this.endmoney = endmoney;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
}
