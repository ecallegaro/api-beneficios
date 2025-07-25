package com.beneficios.presentation;

import com.beneficios.application.BeneficioService;
import com.beneficios.domain.model.Benefit;
import com.beneficios.utils.Jsons;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BenefitController.class)
@Import(BenefitController.class)
@AutoConfigureMockMvc(addFilters = false)
class BeneficioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BeneficioService beneficioService;

    private final String prefix = "/benefits";

    @Test
    void should_return_400_if_request_invalidTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(prefix)
                                .contentType(MediaType.APPLICATION_JSON)
                        //.content(null))
                )
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

    @Test
    void createBenefitTest() throws Exception {
        var benefit = Benefit.builder()
                .nome("Name test")
                .description("DescriptionTest")
                .ativo(true)
                .build();

        Mockito.when(beneficioService.criar(Mockito.any())).thenReturn(benefit);

        mockMvc.perform(MockMvcRequestBuilders.post(prefix)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.toJson(benefit))
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
