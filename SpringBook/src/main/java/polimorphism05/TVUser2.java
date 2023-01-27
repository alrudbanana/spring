package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import oracle.security.o3logon.a;

public class TVUser2 {

	public static void main(String[] args) {
		
	// 1. Spring 컨테이너를 구동 
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
	
	//2. Spring 컨테이너로부터 필요한 객체를 Lookup 한다. => DI객체를 주입 
	
		
		TV tv = (TV) factory.getBean("sonyTV");
		
		//클라이언트 코드 블락 : 외부에서 객체를 생성해서 주입받을때 수정하지 않아도 됨. 

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
