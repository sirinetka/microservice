package com.exmple.Auth;



import com.example.dto.ClientRequest;
import com.example.dto.ClientResponses;
import com.exmple.Auth.ClientInterfaceService;
import com.exmple.Auth.ClientServiceImp;
import com.netflix.servo.util.ThreadCpuStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserContollerApi {
    @Autowired
    ClientInterfaceService clientServiceImp;
   


    @GetMapping("/client")
    public List<ClientResponses> getall(){

        return clientServiceImp.getAll();
    }

    @GetMapping("/client/{id}")
    public ClientResponses getId(@PathVariable("id") Long  id){

        return clientServiceImp.getById(id);
    }

    @PostMapping("/client")
    public void add(@RequestBody ClientRequest request){
        clientServiceImp.add(request);

    }

    @PutMapping("/client/{id}")
    public String update(@RequestBody ClientRequest res,@PathVariable ("id")Long id){
        clientServiceImp.modifier(id,res);
        return "updated";

    }
    @DeleteMapping("/client/{id}")
    public String delete(@PathVariable ("id")Long id){
    	System.out.println(id);
        clientServiceImp.supprimer(id);
        
        return "deleted";
    }





}

