package com.board2.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private Long idx;			//글번호(PK)
	private String title;		//제목
	private String content;		//내용
	private String writer;		//작성자
	private int viewCnt;		//조회수
	private String noticeYn;	//공지 여부
	private String secretYn;	//비밀글 여부
	private String deleteYn;	//삭제 여부
	private String insertTime;	//등록일
	private String updateTime;	//수정일
	private String deleteTime;	//삭제일
	
}
