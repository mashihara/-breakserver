package com.example.breakserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	@Id @GeneratedValue
	int sequence;
	int roomId;
	String name;
	String myAvatarUserName;
	String talkingaAvatarName;
	String myAvatarImgId; 
	String talkingaAvatarImgId;

	int status; //0:wait 1:match
	public Room(int roomId){
		this.roomId=roomId;
	}
}
