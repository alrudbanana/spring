package polimorphism05;


public class SonySpeaker implements Speaker {

	@Override
	public void volumup() {
		System.out.println("SonySpeaker - �����");

	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker - ����ٿ�");

	}

}
