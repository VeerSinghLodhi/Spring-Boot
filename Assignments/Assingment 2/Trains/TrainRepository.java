package com.practice.practiceProgram.Trains;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<TrainMaster,Integer> {
//    List<TrainMaster>findById(int tno);
//    List<TrainMaster>findByName(String tname);
//      List<TrainMaster>findByTnoAndSource(int tno,String source);
//List<TrainMaster>findByTnoOrSource(int tno,String source);
//List<TrainMaster>findByTnoOrSourceIgnoreCase(int tno,String source);
    List<TrainMaster>findByTnoOrSourceContainingIgnoreCase(int tno,String source);
}
