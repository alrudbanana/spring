package polimorphism05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class AppleTV implements TV {
	
	@Resource(name="speaker2")	//@Resource:  @Autowired + @Qualifier 를 하나로 사용함 . Java 의 Annotation 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("AppleTV - 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("AppleTV - 전원을 끕니다.");
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
