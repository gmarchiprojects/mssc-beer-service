package br.com.gmarchiprojects.msscbeerservice.web.controller;

import br.com.gmarchiprojects.msscbeerservice.bootstrap.BeerLoader;
import br.com.gmarchiprojects.msscbeerservice.domain.Beer;
import br.com.gmarchiprojects.msscbeerservice.web.model.BeerDto;
import br.com.gmarchiprojects.msscbeerservice.web.model.BeerStyleEnum;
import br.com.gmarchiprojects.msscbeerservice.web.services.BeerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;
    @Test
    void getBeerById() throws Exception{

        given(beerService.getById(any())).willReturn(getBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        given(beerService.saveNewBeer(any())).willReturn(getBeerDto());

        BeerDto beerDto = getBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{

        given(beerService.updateBeer(any(), any())).willReturn(getBeerDto());

        BeerDto beerDto = getBeerDto();
        String beerDtotoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtotoJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getBeerDto(){
        return BeerDto.builder()
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .upc(BeerLoader.BEER_1_UPC)
                .price(new BigDecimal("11.95"))
                .build();
    }
}