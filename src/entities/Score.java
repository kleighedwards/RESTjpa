package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private float value;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value="userScores")
	private User user;
	
	
	@JoinColumn(name="quiz_id")
	private int quiz_id;

	//Gets and Sets
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getQuizID() {
		return quiz_id;
	}

	public void setQuizID(int quizId) {
		this.quiz_id = quizId;
	}

	public int getId() {
		return id;
	}
	
}
