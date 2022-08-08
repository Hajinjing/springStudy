package com.mega.board.dto;

import com.mega.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

// 데이터 전달 객체인 dto
// dto는 Controller <> Service <> Repository 간에 필요한 데이터를 캡슐화한 데이터 전달 객체

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // dto에서 필요한 부분만 빌더 패턴을 통해서 entity로 만듦
    public BoardEntity toEntity() {
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long id, String writer, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
