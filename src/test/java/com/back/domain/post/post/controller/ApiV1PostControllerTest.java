package com.back.domain.post.post.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test") //test 프로파일 활성화
@SpringBootTest //test 클래스임을 나타낸다
@AutoConfigureMockMvc //MockMvc를 자동으로 설정
@Transactional //각 테스트 메서드가 종료되면 롤백
public class ApiV1PostControllerTest {
    @Autowired
    private MockMvc mvc; //MockMvc를 주입받는다

    @Test
    @DisplayName("글 작성")
    void t1() throws Exception {
        ResultActions resultActions = mvc
                .perform(
                        post("/api/v1/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                        "title": "제목",
                                        "content": "내용"
                                        }
                                        """)
                )
                .andDo(print()); //결과 출력

        resultActions
                .andExpect(status().isCreated());
    }
}
