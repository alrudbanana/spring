package polimorphism05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import oracle.security.o3logon.a;

public class TVUser {

	public static void main(String[] args) {
		
		
		//객체 생성을 Spring Framework 에서 생성 후 DI를 통해서 객체를 주입 
			//1.XML 파일에서 객체를 생성 주입 
				//src/main/resource : 주로 설정에 관련된 내용을 저장하는 곳 (mybatis 매퍼설정, bean의 xml, db Connecttion)
				//applicationContext.xml : Bean을 셋팅하는 파일, spring Framework에서 생성 
		
		//2. @(어노테이션)을 사용해서 객체를 생성 후 DI(객체를 주입)<==spring boot 사용하는 방식 
			//a. @(어노테이션)을 사용할 수 있도록 설정이 필요함. 
			//applicationContext.xml : Bean 구성 파일 , 어노테이션을 사용할 수 있도록  설정 필요
			//<context:component-scan base-package="polimorphism05"></context:component-scan>
		//b. 클래스 위에 @component 어노테이션을 붙여서 객체를 생성 
			//@Component : 일반적인 클래스를 Bean (객체화) 생성 
			//@Service 	 : 비지니스 로직을 처리하는 클래스에 Bean 생성
			//@Repository : 데이터 베이스 연동을 처리하는 DAO 클래스에 생성
			//@Controller	: 사용자 요청을 Controller 클래스에 붙여주는 
		
		//c. Spring Framework에서 생성된 객체를 의존성 주입(DI) 하는 어노테이션 
			//클래스 내부에서 클래스 변수에 할당 
			//@Autowired : 해당 타입의 객체를 찾아서 자동으로 할당하는 어노테이션
				//해당 타입의 객체가 여러개 존재할 경우, 오류가 발생
			//@Qualifier : 특정 객체 이름을 사용해서 불러오는 것 , @Autowired와 같이 사용함 
		
			//@Inject: 자바에서 제공되는 어노테이션 , @Autowired 와 동일한 어노테이션 ( 타입으로 객체를 가지고 온다.)
			//@Resource : 자바에서 제공되는 어노테이션. 
				//@Autowired + @Qualifier 를 하나로 사용함
		
	// 1. Spring 컨테이너를 구동 
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
	
	//2. Spring 컨테이너로부터 필요한 객체를 Lookup 한다. => DI객체를 주입 
		TV tv = (TV) factory.getBean("appleTV");
		
		//클라이언트 코드 블락 : 외부에서 객체를 생성해서 주입받을때 수정하지 않아도 됨. 

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
