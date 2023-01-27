package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//이름안넣으면 클래스이름으로 생성
public class SonyTV implements TV {
	
	@Autowired //Speaker 타입의 객체를 Spring Framework 에서 검색해서 주입 (DI)
				//BossSpeaker , SonySpeaker <== 두개의 객체 모두 스피커 타입을 내포함 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("SonyTV - 전원을 컵니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SonyTV - 전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		speaker.volumup();
	}
	@Override
	public void volumeDown() {
		speaker.volumDown();
		}
}
