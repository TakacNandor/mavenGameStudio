package GameStudio.Main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import GameStudio.GuestWhatIMean.GuesConsoleUI;
import GameStudio.Minesweeper.consoleui.ConsoleUI;
import GameStudio.Minesweeper.core.Field;
import GameStudio.Stones.core.GameField;
import GameStudio.score.HallOfFameHibernate;
import GameStudio.score.Rating;

public class Studio {
	private ConsoleUI mUI;
	private GuesConsoleUI gUI;
	private GameField sUI;
	Scanner sc = new Scanner(System.in);

	public void play() throws Exception {
		System.out.println("1. Minesweeper\n2. Stones\n3. Gues number. \n4. End. \nChoose your game: \n");

		switch (sc.nextInt()) {
		case 1:
					
			mUI.play();
			endGame(mUI.getHall());
			play();
			break;
		case 2:
			sUI.play();
			endGame(sUI.getHall());
			play();
			break;
		case 3:
			System.out.println("Range:");
			gUI.setRange(sc.nextInt());
			gUI.play();
			endGame(gUI.getHall());
			play();
			break;

		case 4:
			System.exit(0);

		default:
			break;
		}
	}

	private void endGame(HallOfFameHibernate hall) throws Exception {
		getEndMenu();
		switch (sc.nextInt()) {
		case 1:
			System.out.println(hall.ratingToString());
			break;
		case 2:
			System.out.println(hall.commentToString());
			break;
		case 3:
			System.out.println(hall.scoreToString());
			break;
		case 4:
			hall.addComment();
			break;
		case 5:
			hall.addRating();
			break;
		case 6:
			//hall.addScore(System.getProperty("user.name"), getPlayingSeconds());
			break;
		case 7:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	private void getEndMenu(){
		System.out.println("1. Show ratings.");
		System.out.println("2. Show comments.");
		System.out.println("3. Show scores.");
		System.out.println("4. Comment game.");
		System.out.println("5. Rate game.");
		System.out.println("6. Save score.");
		System.out.println("7. End.");
	}

	public void setmUI(ConsoleUI mUI) {
		this.mUI = mUI;
	}

	public void setgUI(GuesConsoleUI gUI) {
		this.gUI = gUI;
	}

	public void setsUI(GameField sUI) {
		this.sUI = sUI;
	}

}
