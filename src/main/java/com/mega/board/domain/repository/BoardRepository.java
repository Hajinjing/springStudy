package com.mega.board.domain.repository;

import com.mega.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// 데이터 조작을 담당

public interface BoardRepository extends JpaRepository<BoardEntity, Long>    {
}

// JpaRepository의 제네릭 타입에는 Entity 클래스와, PK의 타입을 명시해줌
// JpaRepository에 일반적으로 많이 사용하는 데이터 조작을 다루는 함수가 정의되어 있기 때문에 CRUD작업이 쉬워짐
// JpaRepository를 상속받았기 때문에 @Repository 생략 가능