package ca.sheridancollege.database;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Question;

@Repository
public class DatabaseAccess {
	
	@Autowired
	public NamedParameterJdbcTemplate jdbc;

	
	public Question getQuestion(String category, int value)
	{
		String q = "Select * from jeopardy where category = :category AND value = :value";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("category", category);
		parameters.addValue("value",value);
		ArrayList<Question> questions = (ArrayList<Question>)jdbc.query(q, parameters,new BeanPropertyRowMapper<Question>(Question.class));
				
		if(questions.size()>0)
		{
			return questions.get(0); 
		}
		else
		{
			return null;
		}

	}

}
