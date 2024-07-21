package com.company.dto;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class PagingDto {
	
	private int listTotal;
	private int onepageLimit;
	private int pageAll;
	private int bottomlist;
	private int pstartno;
	private int currentBtn;
	private int startBtn;
	private int endBtn;
	
	public PagingDto() {
	}

	public PagingDto(int pstartno , int listTotal) { // 0, 10, 20, 30,,,
		this();
//		private int listTotal; 전체 레코드 수 DB에 insert를 256번 되어져 있는 상태
		this.listTotal = listTotal;
		
//		private int onepageLimit; 게시판 페이지에 몇개의 DB가 나오는 것도 계산식에 넣어줘야 한다. 지금은 10줄당 1페이지 이동으로 가정
		this.onepageLimit = 20;
		
		
		////////// 여기서부터 parameter의 영향을 받는다 =============================================
		
		
//		private int pageAll; DB에 따라 몇개의 페이지가 나올지 모르겠으나 전체 페이지를 계산한 것이다.
//		페이지의 갯수는 (전체 레코드 / 설정 레코드 갯수)를 반올림한 값이다.
		if(listTotal<=0) {listTotal=1;}
		else { pageAll = (int) Math.ceil(listTotal/(float)(onepageLimit)); }
		
//		private int bottomlist; 하단 네비바 10개 1~10까지의 버튼을 만들고 양 쪽 이전< >이후 버튼을 만든다.
		this.bottomlist = 10;

//		private int pstartno; 0, 10, 20, 30,,, 번째에서 부터 10개를 보여줄거야. ?pstartno=0 , 10,,,
		this.pstartno = pstartno;
		
//		private ArrayList<JSTLItemDao2> list10; 0, 10, 20, 30,,, 번째에서 부터 10개를 select 해오는 함수
		// this.list10 = dao.listpage(pstartno);
		
		this.currentBtn = (int) Math.ceil((pstartno+1)/(float) onepageLimit);
		// 1 page = ((레코드 0~9 까지의 10개)+1)올림 / 10
		// 현재 페이지는 레코드의 갯수로 페이지를 판별한다.
		
		this.startBtn = (((int) Math.floor((this.currentBtn-1)/(float)this.bottomlist))*bottomlist) + 1;
		
		this.endBtn = this.startBtn + bottomlist -1; // 이렇게만하면 끝자리가 무조건 30이 뜨는데 중간 컨텐츠가 없을 수도 있는것을 가정해야한다.
		
		// 따라서 조건을 써준다.
		if(this.pageAll< this.endBtn) {this.endBtn = this.pageAll;}
		
	}


	public PagingDto(int listTotal, int onepageLimit, int pageAll, int bottomlist, int pstartno, int currentBtn,
			int startBtn, int endBtn) {
		super();
		this.listTotal = listTotal;
		this.onepageLimit = onepageLimit;
		this.pageAll = pageAll;
		this.bottomlist = bottomlist;
		this.pstartno = pstartno;
		this.currentBtn = currentBtn;
		this.startBtn = startBtn;
		this.endBtn = endBtn;
	}


	@Override
	public String toString() {
		return "PagingDto [listTotal=" + listTotal + ", onepageLimit=" + onepageLimit + ", pageAll=" + pageAll
				+ ", bottomlist=" + bottomlist + ", pstartno=" + pstartno + ", currentBtn=" + currentBtn + ", startBtn="
				+ startBtn + ", endBtn=" + endBtn + "]";
	}


}