package com.example.breakserver.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Voice implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //postgersの場合、GeneratedValueにこれがいる
	private Integer voiceId;
	private String voiceContent;
	private String tentativeUserId;
	private String deviceSerialId;
	@JsonFormat(pattern = "M/d H:m")
	@CreatedDate private LocalDateTime createdDate;

	public Voice(String voiceContent,String tentativeUserId,String deviceSerialId){
		this.voiceContent=voiceContent;
		this.tentativeUserId=tentativeUserId;
		this.deviceSerialId=deviceSerialId;
	}
}
