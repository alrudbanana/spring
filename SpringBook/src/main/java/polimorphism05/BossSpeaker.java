package polimorphism05;

import org.springframework.stereotype.Component;

//@Component("speaker")	//BossSpeaker speaker = new BossSpeaker(); 
public class BossSpeaker implements Speaker {

	@Override
	public void volumup() {
		System.out.println("BossSpeaker - ���� �� ");

	}

	@Override
	public void volumDown() {
		System.out.println("BossSpeaker - ���� �ٿ� ");

	}

}
