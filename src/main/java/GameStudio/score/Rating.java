package GameStudio.score;



import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.id.SelectGenerator;

@Entity
public class Rating {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String game;
	private int rating;
	
	public Rating() {

	}

	public Rating(String name, int rating, String game) {
		super();
		this.name = name;
		this.game = game;
		this.rating = rating;
		
	}
	
	public void rateGame(String game) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		setName(System.getProperty("user.name"));
		System.out.println("Please rate this game(1-10): ");

		int userRating = sc.nextInt();
		if (0 > userRating || 10 < userRating) {
			System.out.println("Invalid input. Please enter the number between 1 and 10!");
			userRating = sc.nextInt();
		}
		setRating(userRating);
		setGame(game);
	}

	public String getName() {
		return name;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
