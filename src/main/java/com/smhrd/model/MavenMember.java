package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MavenMember {
	private String mId;
	private String mPw;
	private String mNickName;

	
	public MavenMember(String mId, String mPw) {
		super();
		this.mId = mId;
		this.mPw = mPw;
	}

	// alt + shift + s
	
	
}
