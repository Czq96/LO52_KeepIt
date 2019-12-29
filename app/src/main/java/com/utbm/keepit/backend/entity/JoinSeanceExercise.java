package com.utbm.keepit.backend.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinSeanceExercise {
    private Long seanceId;
    private Long exerciseId;
    @Generated(hash = 1471937566)
    public JoinSeanceExercise(Long seanceId, Long exerciseId) {
        this.seanceId = seanceId;
        this.exerciseId = exerciseId;
    }
    @Generated(hash = 992670927)
    public JoinSeanceExercise() {
    }
    public Long getSeanceId() {
        return this.seanceId;
    }
    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }
    public Long getExerciseId() {
        return this.exerciseId;
    }
    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
