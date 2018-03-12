package com.startrac.stspringdata.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.startrac.stspringdata.services.HipsterService;

public class HipsterControllerTest {

    HipsterController hipsterController;

    @Mock
    HipsterService hipsterService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hipsterController = new HipsterController(hipsterService);
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hipsterController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    
    @Test
    public void getIndexPage() {
        String returnPage = hipsterController.getIndexPage(model);

        assertEquals("index", returnPage);
        verify(hipsterService, times(1)).listAllHipsters();
        verify(model, times(1)).addAttribute(eq("hipsters"), anySet());

    }


}
