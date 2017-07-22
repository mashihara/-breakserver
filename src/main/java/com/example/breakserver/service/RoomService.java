package com.example.breakserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.breakserver.domain.Room;
import com.example.breakserver.repository.RoomRepository;

@Service
@Transactional

public class RoomService {
	@Autowired
	RoomRepository roomRepository;

	public Room insertUser(Room room){
	    return roomRepository.save(room);
	}

	public Room findOne(int sequence){
	    return roomRepository.findOne(sequence);
	}
}
