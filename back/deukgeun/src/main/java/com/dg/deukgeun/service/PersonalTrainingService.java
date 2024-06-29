package com.dg.deukgeun.service;
//작성자 : 허승돈

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.dg.deukgeun.dto.personalTraining.PersonalTrainingDTO;
import com.dg.deukgeun.entity.PersonalTraining;
import com.dg.deukgeun.repository.PersonalTrainingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
// import lombok.extern.log4j.Log4j2;

@Service
@Transactional
// @Log4j2
@RequiredArgsConstructor
public class PersonalTrainingService {
    private final ModelMapper modelMapper;
    private final PersonalTrainingRepository personalTrainingRepository;

    //서비스를 구분하기 쉽도록 메서드의 이름은 각각 대응되는 mysql 쿼리 이름으로 적어두겠습니다.
    // @PreAuthorize("hasRole('ROLE_GENERAL')")
    public Integer insert(PersonalTrainingDTO personalTrainingDTO){
        PersonalTraining personalTraining = modelMapper.map(personalTrainingDTO,PersonalTraining.class);
        PersonalTraining savedPersonalTraining = personalTrainingRepository.save(personalTraining);
        return savedPersonalTraining.getPtId();
    }

    //ptId로 search가 필요할 때 사용
    //ptSession에서 정보가 필요할 때 등
    public PersonalTrainingDTO selectByptId(Integer ptId){
        Optional<PersonalTraining> result = personalTrainingRepository.findById(ptId);
        PersonalTraining personalTraining = result.orElseThrow();
        PersonalTrainingDTO personalTrainingDTO = modelMapper.map(personalTraining,PersonalTrainingDTO.class);
        return personalTrainingDTO;
    }

    //pt 데이터를 조회하는 입장 : 트레이너
    public List<PersonalTrainingDTO> selectByTrainer(Integer trainerId){
        List<PersonalTraining> result = personalTrainingRepository.findByTrainerId(trainerId);
        List<PersonalTrainingDTO> dtoList = new ArrayList<>();
        for(int i=0;i<result.size();i++){
            dtoList.add(modelMapper.map(result.get(i),PersonalTrainingDTO.class));
        }
        return dtoList;
    }

    //pt 데이터를 조회하는 입장 : 개인 유저
    public List<PersonalTrainingDTO> selectByUser(Integer userId){
        List<PersonalTraining> result = personalTrainingRepository.findByUserId(userId);
        List<PersonalTrainingDTO> dtoList = new ArrayList<>();
        for(int i=0;i<result.size();i++){
            dtoList.add(modelMapper.map(result.get(i),PersonalTrainingDTO.class));
        }
        return dtoList;
    }

    //pt 데이터 수정 메서드.
    //pt에 남은 pt 수를 업데이트 할 때 사용
    public void update(Integer ptId){
        Optional<PersonalTraining> result = personalTrainingRepository.findById(ptId);

        PersonalTraining personalTraining = result.orElseThrow();

        personalTraining.setPtCountRemain(personalTraining.getPtCountRemain()-1);
        personalTrainingRepository.save(personalTraining);
    }

    //pt에 남은 pt 수를 복구할 때, 즉, pt 일정이 취소되었을 때 사용

    //pt 정보 삭제 메서드
    public void delete(Integer ptId){
        personalTrainingRepository.deleteById(ptId);
    }
}
