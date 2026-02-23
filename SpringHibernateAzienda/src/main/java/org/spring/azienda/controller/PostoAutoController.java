package org.spring.azienda.controller;


import org.spring.azienda.dto.PostoAutoDTO;
import org.spring.azienda.service.PostoAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/postiauto")
public class PostoAutoController {

    @Autowired
    PostoAutoService paService;

    @PostMapping(path = "/", consumes = "application/json")
    public void inserisciPostoAuto(@RequestBody PostoAutoDTO dto){
        paService.inserisciPostoAuto(dto);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<PostoAutoDTO> selectAll(){
        return paService.selectAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public PostoAutoDTO selectPostoAutoById(@PathVariable int id){
        return paService.selectPostoAutoById(id);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public PostoAutoDTO deletePostoAuto(@PathVariable int id){
        return paService.deletePostoAuto(id);
    }

}
