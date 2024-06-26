package com.MobileProgramming.domain;

import com.MobileProgramming.domain.compositeKey.VerificationID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@IdClass(VerificationID.class)
public class Verification {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Id
    @Column(name = "mission_id")
    private int missionId;

    @Id
    @Column(name = "verifier_id")
    private int verifierId;

    @Column(name = "verify_date")
    private Date verifyDate;

    @Builder
    public Verification(int user, int mission_id, int verifierId, Date date) {
        this.userId = user;
        this.missionId = mission_id;
        this.verifierId = verifierId;
        this.verifyDate = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verification that = (Verification) o;
        return userId == that.userId && missionId == that.missionId && verifierId == that.verifierId && Objects.equals(verifyDate, that.verifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, missionId, verifierId, verifyDate);
    }
}



