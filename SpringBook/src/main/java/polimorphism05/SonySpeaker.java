package polimorphism05;

import org.springframework.stereotype.Component;

	@Component("speaker2")
public class SonySpeaker implements Speaker {
		//��������Ŀ�� ����Ŀ�� ��ü�� �����ִ�. 
	
	@Override
	public void volumup() {
		System.out.println("SonySpeaker - �����");

	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker - ����ٿ�");

	}

}
