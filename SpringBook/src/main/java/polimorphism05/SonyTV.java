package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//�̸��ȳ����� Ŭ�����̸����� ����
public class SonyTV implements TV {
	
	@Autowired //Speaker Ÿ���� ��ü�� Spring Framework ���� �˻��ؼ� ���� (DI)
				//BossSpeaker , SonySpeaker <== �ΰ��� ��ü ��� ����Ŀ Ÿ���� ������ 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("SonyTV - ������ �Ŵϴ�.");
	}
	@Override
	public void powerOff() {
		System.out.println("SonyTV - ������ ���ϴ�.");
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
