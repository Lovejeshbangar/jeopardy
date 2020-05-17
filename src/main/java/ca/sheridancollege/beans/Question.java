package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -312098016301374354L;
	private String category;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String correctAnswer;
	private int value;

}
