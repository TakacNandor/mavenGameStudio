package GameStudio.score;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import GameStudio.Stones.core.GameField;

@Component
public class HallOfFameHibernate extends HallOfFame{

			
	
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public void addScore(String name, int time, String game) throws Exception{
		entityManager.persist(new UserScore(name,time, game));
	} 
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<UserScore> loadScore(String name, int time, String game) throws Exception{
		return entityManager.createQuery("select s from userscore", UserScore.class).getResultList();
	} 
}