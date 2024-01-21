package com.ll.simpleDb;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Article {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private String title;
    private String body;
    private boolean isBlind;

}
