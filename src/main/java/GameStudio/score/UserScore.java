package GameStudio.score;

import java.io.Serializable;

public class UserScore implements Serializable, Comparable<UserScore> {
	//private static final long serialVersionUID = 1L;
	private long id;
	private  String name;
	private  int time;
	private String game;

	
	public UserScore() {
		
	}
	
	public UserScore(String name, int time, String game) {
		this.name = name;
		this.time = time;
		this.game = game;
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTime(int time) {
		this.time = time;
	}

	

	public String getName() {
		return name;
	}
	
	public int getTime() {
		return time;
	}

	
	@Override
	public String toString() {
		return "UserScore [name=" + name + ", time=" + time + ", game=" + game + "]";
	}

	@Override
	public int compareTo(UserScore o) {		
		return time - o.time;
//		if(time < o.time)
//			return -1;
//		else if(time > o.time)
//			return 1;
//		return 0;
	}
}
