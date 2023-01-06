package br.com.gmarchiprojects.msscbeerservice.web.services.inventory;

import java.util.UUID;

public interface BeerInvetoryService {

    Integer getOnhandInventory(UUID beerId);
}
