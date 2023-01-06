package br.com.gmarchiprojects.msscbeerservice.web.mappers;

import br.com.gmarchiprojects.msscbeerservice.domain.Beer;
import br.com.gmarchiprojects.msscbeerservice.web.model.BeerDto;
import br.com.gmarchiprojects.msscbeerservice.web.services.inventory.BeerInvetoryService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper{

    private BeerInvetoryService beerInvetoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInvetoryService(BeerInvetoryService beerInvetoryService) {
        this.beerInvetoryService = beerInvetoryService;
    }
    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInvetoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}
