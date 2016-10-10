package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Answer;

public class AnswerTest {

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
		Answer answer = em.find(Answer.class, 1);
		
		assertEquals("Yes.", answer.getAnswerText());
		
		assertEquals(true, answer.isCorrect());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
        emf.close();
	}
}
