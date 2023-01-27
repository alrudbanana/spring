package polimorphism05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class AppleTV implements TV {
	
	@Resource(name="speaker2")	//@Resource:  @Autowired + @Qualifier �� �ϳ��� ����� . Java �� Annotation 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("AppleTV - ������ �մϴ�.");
	}
	@Override
	public void powerOff() {
		System.out.println("AppleTV - ������ ���ϴ�.");
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
