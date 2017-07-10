package com.example.breakserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.breakserver.domain.Voice;

public interface VoiceRepository extends JpaRepository<Voice,Integer>{

}
