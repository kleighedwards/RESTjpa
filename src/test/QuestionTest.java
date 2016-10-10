package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Question;

public class QuestionTest {
	
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
		Question question = em.find(Question.class, 1);
		
		assertEquals("Imagine how is touch the sky?", question.getQuestionText());
		
		assertEquals(2, question.getAnswers().size());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
        emf.close();
	}
}
