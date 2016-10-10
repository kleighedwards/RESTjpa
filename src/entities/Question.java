package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="question_text")
	private String questionText;
	
//	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@OneToMany(fetch=FetchType.EAGER, orphanRemoval=true, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="question_id", referencedColumnName="id", nullable = false)
    private Set<Answer> answers;
	
	@ManyToOne
    @JoinColumn(name="quiz_id", referencedColumnName="id", nullable=false)
    @JsonBackReference
    private Quiz quiz;
	
	public String getQuestionText() {
		return questionText;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public int getId() {
		return id;
	}
}
