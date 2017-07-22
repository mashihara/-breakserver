package com.example.breakserver.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //postgersの場合、GeneratedValueにこれがいる
	private Integer voiceId;
	private String voiceContent;
	private String tentativeUserId;
	private String deviceSerialId;
	
	public Voice(String voiceContent,String tentativeUserId,String deviceSerialId){
		this.voiceContent=voiceContent;
		this.tentativeUserId=tentativeUserId;
		this.deviceSerialId=deviceSerialId;
	}
}
