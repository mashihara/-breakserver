package com.example.breakserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.breakserver.domain.Room;


public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Query("SELECT x FROM Room x Where x.status=0 ORDER BY x.sequence")
    List<Room> findNoMatching();

   //@Query("SELECT COUNT(*) FROM Room x Where x.status=0 ORDER BY x.sequence")
   // SELECT count(*) from Room where status = 0
    int countByStatusIs(int status);
}


