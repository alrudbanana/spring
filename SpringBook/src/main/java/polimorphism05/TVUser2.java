package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import oracle.security.o3logon.a;

public class TVUser2 {

	public static void main(String[] args) {
		
	// 1. Spring �����̳ʸ� ���� 
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
	
	//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� Lookup �Ѵ�. => DI��ü�� ���� 
	
		
		TV tv = (TV) factory.getBean("sonyTV");
		
		//Ŭ���̾�Ʈ �ڵ� ��� : �ܺο��� ��ü�� �����ؼ� ���Թ����� �������� �ʾƵ� ��. 

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
