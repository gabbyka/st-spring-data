package com.startrac.stspringdata.controllers;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import com.startrac.stspringdata.model.Hipster;
import com.startrac.stspringdata.services.HipsterService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
    public void getIndexPage() {
        String returnPage = hipsterController.getIndexPage(model);

        assertEquals("index", returnPage);
        verify(hipsterService, times(1)).listAllHipsters();
        verify(model, times(1)).addAttribute(eq("hipsters"), anySet());

    }


}
