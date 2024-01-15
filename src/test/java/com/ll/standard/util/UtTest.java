package com.ll.standard.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UtTest {
    private final String testfilePath = "temp/test.txt";

    @BeforeEach
    void beforeEach(){
        Ut.file.save(testfilePath,"내용");
    }
    @AfterEach
    void afterEach(){
        Ut.file.delete(testfilePath);
    }

    @Test
    @DisplayName("파일 생성")
    void t1(){
        assertThat(Ut.file.exists(testfilePath)).isTrue();
    }
    @Test
    @DisplayName("파일내용 읽기")
    void t2(){
        final String content = Ut.file.getContent(testfilePath);

        assertThat(content).isEqualTo("내용");
    }
    @Test
    @DisplayName("파일내용 읽은 후 long 타입으로 변환")
    void t3(){
        final long id = Ut.file.getContentAsLong(testfilePath,0);
        assertThat(id).isEqualTo(0);

        final String test2FilePath = "temp/test2.txt";
        Ut.file.save(test2FilePath,100);
        final long age = Ut.file.getContentAsLong(test2FilePath,0);
        assertThat(age).isEqualTo(100);

        Ut.file.delete(test2FilePath);
    }
    @Test
    @DisplayName("없는 파일 읽으라는 시도를 하면 null 반환")
    void t4(){
        final String content = Ut.file.getContent("temp/non-exists.txt");
        assertThat(content).isNull();
    }
}
