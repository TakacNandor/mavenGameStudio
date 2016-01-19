package GameStudio.Stones.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.mysql.jdbc.Field;

import GameStudio.Stones.core.GameField;
import GameStudio.score.DBConnection;
import GameStudio.score.HallOfFameORM;
import GameStudio.score.UserScore;

public class Main extends DBConnection {

	/*
	 * static final String URL = "jdbc:mysql://localhost/gamestudio"; static
	 * final String USER = "root"; static final String PASSWORDD = "";
	 */

	public static void main(String[] args) throws BeansException, Exception {


		ApplicationContext context = new
		ClassPathXmlApplicationContext("spring-context.xml");
		
		context.getBean(GameField.class).play();
		
		//GameField gameField = new GameField(4);
		//gameField.play();
		
		

	}

}