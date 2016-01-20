package GameStudio.score;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import GameStudio.Stones.core.GameField;

@Component
public class HallOfFameHibernate{

	private String game;
	
	
	public HallOfFameHibernate() {
		
	}

	public HallOfFameHibernate(String game) {
		
		this.game = game;
	}

	

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addScore(String name, int time) throws Exception {
		entityManager.persist(new UserScore(name, time, game));
	}

	public List<UserScore> loadScore() throws Exception {
		return entityManager.createQuery("select s from UserScore s where name like :name", UserScore.class).setParameter("name", "P350%").getResultList();
	}
		
	@Transactional
	public void addRating() throws Exception {
		Rating rating = new Rating();
		rating.rateGame(game);
		List<Rating> ratings = entityManager.createQuery("select r from Rating r where game=:game and name = :name").setParameter("game", game).setParameter("name",rating.getName()).getResultList();
		if (ratings.size()==0) {
			entityManager.persist(rating);
		}else{
			ratings.get(0).setRating());
		}
		
		
	}
	
	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}


	public String toString() {
		List<UserScore> scores;
		try {
			scores = loadScore();
		} catch (Exception e) {
			scores = new ArrayList<>();
		}
		
		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (UserScore score : scores) {
			sb.append(index + ". " + score.getName() + " " + score.getTime() +" " +score.getGame()+ "\n");
			index++;
		}
		return sb.toString();
	} 


}