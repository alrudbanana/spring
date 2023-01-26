package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv3")	//samsungTV tv3 = new SamsungTV;와 같은 의미  tv3는 samsungTv, Tv 
public class SamsungTV implements TV {
	
	
	@Autowired
	private Speaker speaker; 	// 객체 변수 선언 , 현 상태 는 null 
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원을 끕니다.");
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
