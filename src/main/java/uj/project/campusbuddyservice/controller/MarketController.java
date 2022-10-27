package uj.project.campusbuddyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.dto.MarketDto;
import uj.project.campusbuddyservice.entity.Markets;
import uj.project.campusbuddyservice.services.MarketService;

@RestController
@RequestMapping("/api/market")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllItem(){
        return  marketService.getAllItems();
    }

    @GetMapping("/findItem/{id}")
    public ResponseEntity<?> getItemById(@PathVariable("id") long id){
        return marketService.getItemById(id);
    }
    @GetMapping("/findUserItem/{email}")
    public ResponseEntity<?> findUserItems(@PathVariable("email") String postedByEmail){
        return marketService.getItemByUserEmail(postedByEmail);
    }
    @PostMapping("/addNew")
    public ResponseEntity<?> createNew(@RequestBody MarketDto marketDto){
        return marketService.createNewItem(marketDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") long id ,@RequestBody MarketDto marketDto){
      return marketService.updateAnItem(id, marketDto);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteMyItem(@PathVariable("id") long id){
        return  marketService.deleteMyItem(id);
    }
}
