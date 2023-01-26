package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv2")
public class LgTV implements TV {
	
	@Autowired
	//Speaker Ÿ���� ��ü�� ã�Ƽ� speaker ������ ���� 
	private Speaker speaker;
	
	
	@Override
	public void powerOn() {
		System.out.println("LgTV = ������ �մϴ�. ");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV = ������ ���ϴ�. ");
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
