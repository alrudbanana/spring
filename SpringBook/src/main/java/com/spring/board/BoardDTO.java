package com.spring.board;

import java.sql.Date;

public class BoardDTO {
/*
	DTO (VO) : ������ , DB�� ���̺��� �� �÷��̸��� ���� 
	�����͸� �޾Ƽ� �������ִ� �߰��� ���� 
	��� ������ private�� ���� 
	getter/setter �� ����ؼ� ������ ���� �Ҵ�, ������ �� 
	�⺻ �����ڸ� �ݵ�� ������ , BoardDTO() {}
	toString �޼ҵ带 ������ : ��ü ��ü�� ��������� �� ��ü�� �������� Ȯ��
	//������� lombok �� ����ϱ� ��//
	
	lombok �� ����ϸ�, ������̼��� ����ؼ� getter/ setter, toString, �⺻�����ڸ� �ڵ����� ������ش�. 
	*/
	
		
		private int seq; 
		private String title; 
		private String writer;
		private String content; 
		private Date regdate; //sql date ��� 
		private int cnt;
	
//�⺻�����ڸ� �߰� 
		public BoardDTO() {}


		
//getter/setter <== ��� ������ private�̹Ƿ� �ܺο��� ���� �����Ǳ� ������, getter/setter�� ���ؼ� ���� �Ҵ��ϱ� ���� 
		public int getSeq() {
			return seq;
		}

		public void setSeq(int seq) {
			this.seq = seq;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getRegdate() {
			return regdate;
		}

		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}



	
	
//toString () : ��ü ��ü�� ��� �Ҷ� ��ü�� �޸��� ���� ��� �ϵ��� ������ 
		// �⺻�����δ� ��ü�� �������� ��� (hash �ڵ�)
		@Override
		public String toString() {
			return "BoardDTO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
					+ ", regdata=" + regdate + ", cnt=" + cnt + "]";
		}
	
}



