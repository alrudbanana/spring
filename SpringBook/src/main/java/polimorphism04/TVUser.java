package polimorphism04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		
		//��ü ������ Spring Framework ���� ���� �� DI�� ���ؼ� ��ü�� ���� 
			//1.XML ���Ͽ��� ��ü�� ���� ���� 
				//src/main/resource : �ַ� ������ ���õ� ������ �����ϴ� �� (mybatis ���ۼ���, bean�� xml, db Connecttion)
				//applicationContext.xml : Bean�� �����ϴ� ����, spring Framework���� ���� 
		
		//2. @(������̼�)�� ����ؼ� ��ü�� ���� �� DI(��ü�� ����)<==spring boot ����ϴ� ��� 
			
	// 1. Spring �����̳ʸ� ���� 
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
	
	//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� Lookup �Ѵ�. => DI��ü�� ���� 
		TV tv = (TV) factory.getBean("tv");
		
		//Ŭ���̾�Ʈ �ڵ� ��� : �ܺο��� ��ü�� �����ؼ� ���Թ����� �������� �ʾƵ� ��. 

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
