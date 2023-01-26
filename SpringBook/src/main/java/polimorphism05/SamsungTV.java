package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv3")	//samsungTV tv3 = new SamsungTV;�� ���� �ǹ�  tv3�� samsungTv, Tv 
public class SamsungTV implements TV {
	
	
	@Autowired
	private Speaker speaker; 	// ��ü ���� ���� , �� ���� �� null 
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - ������ �մϴ�.");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - ������ ���ϴ�.");
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
