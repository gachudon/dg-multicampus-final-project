package com.dg.deukgeun.dto.personalTraining;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalTrainingDTO {
    private Integer ptId;
    private Integer userId;
    private Integer trainerId;
    private Date regDate;
    private Date expDate;
    private int ptCountTotal;
    private int ptCountRemain;
    private String ptContent;
    private String userPtReason;
    private Integer userGender;
    private Integer userAge;
    private String userWorkoutDur;
}
