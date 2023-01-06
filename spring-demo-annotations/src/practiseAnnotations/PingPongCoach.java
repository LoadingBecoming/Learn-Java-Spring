package practiseAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach{
	@Autowired
	private FortuneService fortuneService;
	
	public PingPongCoach() {
		
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise your PingPong drop short";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
