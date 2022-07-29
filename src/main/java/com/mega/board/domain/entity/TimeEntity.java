package com.mega.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 테이블로 매핑하지 않고, 자식 클래스(엔티티)에게 매핑정보를 상속하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class) // JPA 에게 할당하는 Entity는 Auditing기능을 사용한다는 것을 알리는 어노테이션
public class TimeEntity {

    @CreatedDate
    @Column(updatable = false) // 생성일은 업데이트 할 필요가 없음
    private LocalDateTime createdDate;

    @LastModifiedDate // 수정일자를 주입하는 어노테이션
    private LocalDateTime modifiedDate;
}

