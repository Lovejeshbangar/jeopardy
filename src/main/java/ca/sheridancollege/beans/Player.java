package ca.sheridancollege.beans;
 import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7939575604691593580L;
	private String playerName;
	private int Score;

}
