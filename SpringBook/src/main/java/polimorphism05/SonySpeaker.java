package polimorphism05;

import org.springframework.stereotype.Component;

	@Component("speaker2")
public class SonySpeaker implements Speaker {
		//보스스피커도 스피커의 객체를 갖고있다. 
	
	@Override
	public void volumup() {
		System.out.println("SonySpeaker - 볼룸업");

	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker - 볼룸다운");

	}

}
