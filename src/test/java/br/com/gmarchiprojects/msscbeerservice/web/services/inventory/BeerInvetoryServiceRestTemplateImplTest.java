package br.com.gmarchiprojects.msscbeerservice.web.services.inventory;

import br.com.gmarchiprojects.msscbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
class BeerInvetoryServiceRestTemplateImplTest {

    @Autowired
    BeerInvetoryService beerInvetoryService;

    @BeforeEach
    void setUp(){

    }

    @Test
    void getOnHandInventory(){
        Integer qoh = beerInvetoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);

        System.out.println(qoh);
    }
}