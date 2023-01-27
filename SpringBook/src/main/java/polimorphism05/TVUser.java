package polimorphism05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import oracle.security.o3logon.a;

public class TVUser {

	public static void main(String[] args) {
		
		
		//��ü ������ Spring Framework ���� ���� �� DI�� ���ؼ� ��ü�� ���� 
			//1.XML ���Ͽ��� ��ü�� ���� ���� 
				//src/main/resource : �ַ� ������ ���õ� ������ �����ϴ� �� (mybatis ���ۼ���, bean�� xml, db Connecttion)
				//applicationContext.xml : Bean�� �����ϴ� ����, spring Framework���� ���� 
		
		//2. @(������̼�)�� ����ؼ� ��ü�� ���� �� DI(��ü�� ����)<==spring boot ����ϴ� ��� 
			//a. @(������̼�)�� ����� �� �ֵ��� ������ �ʿ���. 
			//applicationContext.xml : Bean ���� ���� , ������̼��� ����� �� �ֵ���  ���� �ʿ�
			//<context:component-scan base-package="polimorphism05"></context:component-scan>
		//b. Ŭ���� ���� @component ������̼��� �ٿ��� ��ü�� ���� 
			//@Component : �Ϲ����� Ŭ������ Bean (��üȭ) ���� 
			//@Service 	 : �����Ͻ� ������ ó���ϴ� Ŭ������ Bean ����
			//@Repository : ������ ���̽� ������ ó���ϴ� DAO Ŭ������ ����
			//@Controller	: ����� ��û�� Controller Ŭ������ �ٿ��ִ� 
		
		//c. Spring Framework���� ������ ��ü�� ������ ����(DI) �ϴ� ������̼� 
			//Ŭ���� ���ο��� Ŭ���� ������ �Ҵ� 
			//@Autowired : �ش� Ÿ���� ��ü�� ã�Ƽ� �ڵ����� �Ҵ��ϴ� ������̼�
				//�ش� Ÿ���� ��ü�� ������ ������ ���, ������ �߻�
			//@Qualifier : Ư�� ��ü �̸��� ����ؼ� �ҷ����� �� , @Autowired�� ���� ����� 
		
			//@Inject: �ڹٿ��� �����Ǵ� ������̼� , @Autowired �� ������ ������̼� ( Ÿ������ ��ü�� ������ �´�.)
			//@Resource : �ڹٿ��� �����Ǵ� ������̼�. 
				//@Autowired + @Qualifier �� �ϳ��� �����
		
	// 1. Spring �����̳ʸ� ���� 
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
	
	//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� Lookup �Ѵ�. => DI��ü�� ���� 
		TV tv = (TV) factory.getBean("appleTV");
		
		//Ŭ���̾�Ʈ �ڵ� ��� : �ܺο��� ��ü�� �����ؼ� ���Թ����� �������� �ʾƵ� ��. 

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
