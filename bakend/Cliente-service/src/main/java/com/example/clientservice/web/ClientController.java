package com.example.clientservice.web;

import com.example.clientservice.dto.ClientRequest;
import com.example.clientservice.dto.ClientResponses;
import com.example.clientservice.publisher.RabbitProducer;
import com.example.clientservice.service.ClientInterfaceService;
import com.example.clientservice.service.ClientServiceImp;
import com.netflix.servo.util.ThreadCpuStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientController {
    @Autowired
    ClientInterfaceService clientServiceImp;
   


    @GetMapping("/client")
    public List<ClientResponses> getall(){

        return clientServiceImp.getAll();
    }

    @GetMapping("/client/{id}")
    public ClientResponses getId(@PathVariable("id")Integer id){

        return clientServiceImp.getById(id);
    }

    @PostMapping("/client")
    public void add(@RequestBody ClientRequest request){
        clientServiceImp.add(request);

    }

    @PutMapping("/client/{id}")
    public String update(@RequestBody ClientRequest res,@PathVariable ("id")Integer id){
        clientServiceImp.modifier(id,res);
        return "updated";

    }
    @DeleteMapping("/client/{id}")
    public String delete(@PathVariable ("id")Integer id){
    	System.out.println(id);
        clientServiceImp.supprimer(id);
        
        return "deleted";
    }





}
