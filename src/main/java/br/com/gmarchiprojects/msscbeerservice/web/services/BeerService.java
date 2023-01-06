package br.com.gmarchiprojects.msscbeerservice.web.services;

import br.com.gmarchiprojects.msscbeerservice.web.model.BeerDto;
import br.com.gmarchiprojects.msscbeerservice.web.model.BeerPagedList;
import br.com.gmarchiprojects.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of);
}
