package br.com.gmarchiprojects.msscbeerservice.bootstrap;

import br.com.gmarchiprojects.msscbeerservice.domain.Beer;
import br.com.gmarchiprojects.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "01268532145632";
    public static final String BEER_2_UPC = "01225145445632";
    public static final String BEER_3_UPC = "36975208145632";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");


    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    }


}
