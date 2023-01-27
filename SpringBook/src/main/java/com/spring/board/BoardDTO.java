package com.spring.board;

import java.sql.Date;

public class BoardDTO {
/*
	DTO (VO) : 전달자 , DB의 테이블의 각 컬럼이름을 매핑 
	데이터를 받아서 전달해주는 중간자 역할 
	모든 변수는 private로 선언 
	getter/setter 를 사용해서 변수의 값을 할당, 가지고 옴 
	기본 생성자를 반드시 생성함 , BoardDTO() {}
	toString 메소드를 재정의 : 객체 자체를 출력했을때 그 객체의 변수값을 확인
	//여기까지 lombok 을 사용하기 전//
	
	lombok 을 사용하면, 어노테이션을 사용해서 getter/ setter, toString, 기본생성자를 자동으로 만들어준다. 
	*/
	
		
		private int seq; 
		private String title; 
		private String writer;
		private String content; 
		private Date regdate; //sql date 사용 
		private int cnt;
	
//기본생성자를 추가 
		public BoardDTO() {}


		
//getter/setter <== 모든 변수가 private이므로 외부에서 접근 금지되기 때문에, getter/setter를 통해서 값을 할당하기 위해 
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



	
	
//toString () : 객체 자체를 출력 할때 객체의 메모리의 값을 출력 하도록 재정의 
		// 기본적으로는 객체의 번지수를 출력 (hash 코드)
		@Override
		public String toString() {
			return "BoardDTO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
					+ ", regdata=" + regdate + ", cnt=" + cnt + "]";
		}
	
}



