package com.exmple.Auth;


import com.example.dto.ClientRequest;
import com.example.dto.ClientResponses;
import com.exmple.Auth.ClientInterfaceService;
import com.exmple.Auth.ClientServiceImp;
import com.netflix.servo.util.ThreadCpuStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImp implements ClientInterfaceMapper{
	
@Autowired
	UserRepository clientRepository;

    @Override
    public User ClientRequest_To_Client(ClientRequest req) {

        User c=new User();

        c.setName(req.getName());
        c.setUsername(req.getEmail());
        c.setAdresse(req.getAdresse());



        return c;
    }

    @Override
    public ClientResponses Client_To_ClientResponses(User c) {

        ClientResponses res=new ClientResponses();

        res.setName(c.getName());
        res.setAdresse(c.getAdresse());
        res.setIdC(c.getId());
        res.setEmail(c.getUsername());
     
        return res;
    }
}
