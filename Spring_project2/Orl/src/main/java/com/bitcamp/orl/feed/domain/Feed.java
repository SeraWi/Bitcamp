package com.bitcamp.orl.feed.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;


@Repository
public class Feed {
	
	private int boardIdx;
	private String boardPhoto;
	private String boardDiscription;
	private String boardDate;
	private Timestamp hashtag;
	private int memberIdx;
	
}
