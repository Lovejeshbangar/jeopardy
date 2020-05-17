package ca.sheridancollege;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Player;
import ca.sheridancollege.beans.Question;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {
	@Autowired
	public DatabaseAccess db;
	Question ques;
	Player obj;
	int i=0;
	int val;
	@GetMapping("/")
	public String startPage()
	{
		return "index.html";
	}
	@GetMapping("/categories")
	public String secpage(@RequestParam(defaultValue="Lovejesh") String name, HttpSession session)
	{	if(session.isNew())
	{
		obj= new Player(name,i);
		session.setAttribute("contestant", obj);
	}
	return "secondpage.html";
	}
	@GetMapping("/pickQuestion")
	public String pickQuestion(HttpSession session, @RequestParam String category, @RequestParam int value)
	{
		 ques = db.getQuestion(category,value);
		 val=value;
		session.setAttribute("questions", ques);
		return "quiz.html";
		
	}
	@GetMapping("/quit")
	public String quit(HttpSession session)
	{
		session.invalidate();
		i=0;
		return "index.html";
	}

	@GetMapping("/answer")
	public String answer(HttpSession session, @RequestParam String choice)
	{
		
		if(choice.equals(ques.getCorrectAnswer()))
		{
			switch(val)
			{
				case 100:i=i+100;
				break;
				case 200:i=i+200;
				break;
				case 300:i=i+300;
				break;
				case 400: i=i+400;
				break;
				case 500: i=i+500;
				break;
				
			}
			session.setAttribute("answer", "Right Answer");
			obj.setScore(i);
		}
		else
		{
			switch(val)
			{
				case 100:i=i-100;
				break;
				case 200:i=i-200;
				break;
				case 300:i=i-300;
				break;
				case 400: i=i-400;
				break;
				case 500: i=i-500;
				break;
				
			}
			session.setAttribute("answer", "Wrong Answer");
			obj.setScore(i);
		}

		session.setAttribute("contestant", obj);
		
		return "secondpage.html";
	}
	
}
