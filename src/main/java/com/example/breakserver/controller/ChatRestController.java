package com.example.breakserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.breakserver.domain.Room;
import com.example.breakserver.service.RoomService;

@RestController
public class ChatRestController {
	@Autowired
	RoomService roomService;

	@GetMapping(path="/api/selectRoom")
	//Room selectRoom(Model model,@RequestParam String myAvatarUserName){		
	Room selectRoom(Model model){
        //model.addAttribute("myAvatarUserName", myAvatarUserName);
        Room room = new Room();
        //room.setMyAvatarUserName(myAvatarUserName);
		//return roomService.findOne(room.getSequence());

        //TODO
        //まずは1固定
        room.setRoomId(0);
		return room;
	}
}
