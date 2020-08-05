package com.wg.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testUserController {
    private MockMvc mvc;

    @Before
    public void beforeRun() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request;
        MvcResult result;
        //添加新内容
        request = MockMvcRequestBuilders.post("/users/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"id\":1, \"name\":\"json\", \"age\":33}");

        result = mvc.perform(request)
                    .andExpect(MockMvcResultMatchers.content().string("success"))
                    .andReturn();
        System.out.println(result.getResponse().getContentAsString());

        //查询内容
        request = MockMvcRequestBuilders.get("/users/");
        result = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content()
                .string("[{\"id\":1,\"name\":\"json\",\"age\":33}]"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
