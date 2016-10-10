package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Score;
import entities.User;

public class ScoreTest {

	private EntityManagerFactory emf;
    private EntityManager em;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.
	            createEntityManagerFactory("JPAQuiz");
	    em = emf.createEntityManager();	
	}

	@Test
	public void test() {
		Score score = em.find(Score.class, 1);
		
		assertEquals(88.00, score.getValue(),001);
		
//		User user = score.getUser();
//		assertEquals(1, user.getId());
		
		int quizId = score.getQuizID();
		assertEquals(1, quizId);
		
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
        emf.close();
	}


}
