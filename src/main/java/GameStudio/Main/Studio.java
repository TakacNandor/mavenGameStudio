package GameStudio.Main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import GameStudio.Minesweeper.consoleui.ConsoleUI;
import GameStudio.Minesweeper.core.Field;
import GameStudio.Stones.core.GameField;

public class Studio {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	
	
	public void play() throws Exception{
		System.out.println("1. Minesweeper\n2. Stones\n3. End \nChoose your game: \n");
		Scanner sc = new Scanner(System.in);		
		switch (sc.nextInt()) {
		case 1:
			context.getBean(ConsoleUI.class).play();
			break;
		case 2:
			context.getBean(GameField.class).play();
			break;
		case 3:
			
	break;

		default:
			break;
		}
	}
}
