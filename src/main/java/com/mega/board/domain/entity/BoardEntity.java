package com.mega.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// DB테이블과 매핑되는 객체를 정의, JPA와 관련이 깊다(jpa를 사용하려면 entity를 정의해야함)
// Entity : 데이터베이스에 저장하기 위해 유저가 정의한 클래스

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자 추가, Entity는 외부에서 생성할 필요가 없기 때문에 protected
@Getter
@Entity // 엔티티 매핑, JPA가 관리하게 됨
@Table(name = "board") // 별도의 이름을 가진 데이터베에스 테이블과 매핑, name="" 을 생략할 경우 entity 클래스의 이름과 같은 테이블을 찾아서 매핑

public class BoardEntity extends TimeEntity{

    @Id // primary key를 가지는 변수를 선언하는 것을 뜻함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 Id값을 어떻게 자동으로 생성할지 전략 선택
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder //Setter 대신 빌더패턴을 사용하여 안정성 보장
    public BoardEntity(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
