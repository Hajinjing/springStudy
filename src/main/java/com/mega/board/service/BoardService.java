package com.mega.board.service;

import com.mega.board.domain.entity.BoardEntity;
import com.mega.board.domain.repository.BoardRepository;
import com.mega.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


// 서비스는 비지니스 로직을 담당

@AllArgsConstructor // Repository를 주입하기 위한 어노테이션
@Service // 서비스 계층임을 명시
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional // 선언적 트랜잭션이라 부름
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }
}

// dto를 entity로 전달한 이유 : JpaRepository에 정의된 함수들은(save, update 등) 미리 정의되어 있기 때문
//                          JpaRepository의 메소드 save는 entity를 매개변수로 받음