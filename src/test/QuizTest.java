package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Answer;
import entities.Question;
import entities.Quiz;

public class QuizTest {

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
//		Quiz quiz = em.find(Quiz.class, 1);
//		
//		assertEquals("Quiz 1", quiz.getName());
//		
//		assertEquals(6, quiz.getQuestions().size());
	}
	
	@Test
	public void testDelete() {
		Question question = em.find(Question.class, 16);
		
		System.out.println(question.getQuestionText());
		System.out.println(em.contains(question));
		
		em.getTransaction().begin();
		em.remove(question);
		em.getTransaction().commit();
		
		System.out.println("After " + em.contains(question));

	}
	
	//@Test
	public void testAdd() {
		Question question = new Question();
		question.setQuestionText("New Question");
		
		question.setQuiz(em.find(Quiz.class, 1));
		
		Answer answer = new Answer();
		answer.setAnswerText("Answer1");
		answer.setCorrect(true);
		
//		List<Answer> answers = new ArrayList<>();
//		answers.add(answer);
//		
//		question.setAnswers(answers);
		
		System.out.println(question.getQuestionText());
		System.out.println(em.contains(question));
		
		em.getTransaction().begin();
		em.persist(question);
		em.getTransaction().commit();
		
		System.out.println("After " + em.contains(question));

	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
        emf.close();
	}


}
