package com.example._sampleproject_coffee.stemp.entity;


import com.example._sampleproject_coffee.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name ="STAMP")
public class Stamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stampId;

    @Positive
    @Column(nullable = false)
    private int stampCount;

    @Column(nullable = false)
    private LocalDateTime createAt=LocalDateTime.now();
    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @OneToOne
    private Member member;

    public void matchMember(Member member){
        this.member = member;
    }

}
