package uj.project.campusbuddyservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uj.project.campusbuddyservice.dto.MarketDto;
import uj.project.campusbuddyservice.entity.Markets;
import uj.project.campusbuddyservice.repository.MarketRepository;

import java.util.List;
import java.util.Optional;
@Component
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;
//    @Autowired
//    private MarketDto marketDto;

    public ResponseEntity<?> getAllItems(){
        try{
            List<Markets> allMarkets = marketRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(allMarkets));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }

    public ResponseEntity<?> getItemById(long id){
        try{
            Optional<Markets> allMarkets = marketRepository.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(allMarkets));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }

    public ResponseEntity<?> getItemByUserEmail(String email){
        try{
            List<Markets> allMarkets = marketRepository.findAllByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(allMarkets));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));

        }
    }

    public ResponseEntity<?> createNewItem(MarketDto marketDto){
        try{
            Markets newItem = new Markets();
            newItem.setTitle(marketDto.getTitle());
            newItem.setDescription(marketDto.getDescription());
            newItem.setCondition(marketDto.getCondition());
            newItem.setPrice(marketDto.getPrice());
            newItem.setItemUrl(marketDto.getItemUrl());
            newItem.setEmail(marketDto.getEmail());

            marketRepository.save(newItem);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(newItem));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("Error adding new item"));

        }
    }

    public  ResponseEntity<?> updateAnItem(long id, MarketDto marketDto){
        try{
            Optional<Markets> updateitem = marketRepository.findById(id);
            Markets _updateItem = updateitem.get();
            _updateItem.setTitle(marketDto.getTitle());
            _updateItem.setDescription(marketDto.getDescription());
            _updateItem.setCondition(marketDto.getCondition());
            _updateItem.setPrice(marketDto.getPrice());
            _updateItem.setItemUrl(marketDto.getItemUrl());
            _updateItem.setEmail(marketDto.getEmail());
            marketRepository.save(_updateItem);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(_updateItem));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }
}
