package polimorphism05;

import org.springframework.stereotype.Component;

//@Component("speaker")	//BossSpeaker speaker = new BossSpeaker(); 
public class BossSpeaker implements Speaker {

	@Override
	public void volumup() {
		System.out.println("BossSpeaker - º¼·ý ¾÷ ");

	}

	@Override
	public void volumDown() {
		System.out.println("BossSpeaker - º¼·ý ´Ù¿î ");

	}

}
