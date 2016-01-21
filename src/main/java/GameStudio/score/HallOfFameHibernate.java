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
public class HallOfFameHibernate {

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
		return entityManager.createQuery("select s from UserScore s where name like :name", UserScore.class)
				.setParameter("name", "P350%").getResultList();
	}

	@Transactional
	public void addRating() throws Exception {
		Rating rating = new Rating();
		rating.rateGame(game);
		List<Rating> ratings = entityManager.createQuery("select r from Rating r where game=:game and name = :name")
				.setParameter("game", game).setParameter("name", rating.getName()).getResultList();
		if (ratings.size() == 0) {
			entityManager.persist(rating);
		} else {
			ratings.get(0).setRating(rating.getRating());
			
		}
	}
	
	@Transactional
	public void addComment() throws Exception {
		Comment comment = new Comment();
		comment.createComment(game);
			entityManager.persist(comment);
		} 
	
	public List<Comment> showComment() throws Exception {
		return entityManager.createQuery("select s from Comment s where game like :game", Comment.class)
				.setParameter("game", game).getResultList();
	}
	
	
	public List<Rating> loadRating() throws Exception {
		return entityManager.createQuery("select r from Rating r where name like :name", Rating.class).setParameter("name", "P350%").getResultList();
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String scoreToString() {
		List<UserScore> scores;
		try {
			scores = loadScore();
		} catch (Exception e) {
			scores = new ArrayList<>();
		}

		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (UserScore score : scores) {
			sb.append(index + ". " + score.getName() + " " + score.getTime() + " " + score.getGame() + "\n");
			index++;
		}
		return sb.toString();
	}
	
	public String ratingToString() {
		List<Rating> rating;
		try {
			rating = loadRating();
		} catch (Exception e) {
			rating = new ArrayList<>();
		}

		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (Rating rat : rating) {
			sb.append(index + ". " + rat.getName() + " " + rat.getRating() + " " + rat.getGame() +"\n");
			index++;
		}
		return sb.toString();
	}
	
	public String commentToString() {
		List<Comment> comment;
		try {
			comment = showComment();
		} catch (Exception e) {
			comment = new ArrayList<>();
		}

		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (Comment comm : comment) {
			sb.append(index + ". " + comm.getName() + " " + comm.getComment() +"\n");
			index++;
		}
		return sb.toString();
	}

}