package com.ll.simpleDb;

import org.junit.jupiter.api.*;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
@TestInstance(PER_CLASS)
public class SimpleDbTest {
    private SimpleDb simpleDb;
    @BeforeAll
    public void beforeAll(){
        simpleDb = new SimpleDb("localhost", "root" ,"skfornjs8^","SimpleDb_test");
        simpleDb.setDevMode(true);

        createArticleTable();
    }
    @AfterAll
    public void afterAll(){
        simpleDb.close();
    }
    @BeforeEach
    public void beforeEach(){
        truncateArticleTable();
        makeArticleTestData();
    }


    private void createArticleTable(){
        simpleDb.run("DROP TABLE IF EXISTS article");

        simpleDb.run("""                                                
                CREATE TABLE article (
                    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                    PRIMARY KEY(id),
                    createdDate DATETIME NOT NULL,
                    modifiedDate DATETIME NOT NULL,
                    title VARCHAR(100) NOT NULL,
                    `body` TEXT NOT NULL,
                    isBlind BIT(1) NOT NULL DEFAULT 0
                )
                """);
    }
    private void makeArticleTestData(){
        IntStream.rangeClosed(1, 6).forEach(no -> {
            boolean isBlind = no > 3;
            String title = "제목%d".formatted(no);
            String body = "내용%d".formatted(no);

            simpleDb.run("""
                    INSERT INTO article
                    SET createdDate = NOW(),
                    modifiedDate = NOW(),
                    title = ?,
                    `body` = ?,
                    isBlind = ?
                    """, title, body, isBlind);



        });
    }
    private void truncateArticleTable(){
        simpleDb.run("TRUNCATE article");
    }



    @Test
    @DisplayName("t1")
    void t1(){

    }
}
