package com.librairie.librairie;

import com.librairie.librairie.dto.CollectionDto;
import com.librairie.librairie.service.ILibrairieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/librairie/")
public class LibrairieController {
    @Autowired
    private ILibrairieService librairieService;

    @GetMapping("/findAll")
    public ResponseEntity findAllLibrairie() {
        return new ResponseEntity(librairieService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/find")
    public ResponseEntity find(@RequestBody CollectionDto collectionDto) {
        return new ResponseEntity(librairieService.find(collectionDto), HttpStatus.ACCEPTED);
    }
}
