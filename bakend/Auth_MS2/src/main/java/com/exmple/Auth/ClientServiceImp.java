package com.exmple.Auth;

import com.example.dto.ClientRequest;
import com.example.dto.ClientResponses;
import com.exmple.Auth.User;
import com.exmple.Auth.ClientInterfaceMapper;
import com.exmple.Auth.ClientMapperImp;
import com.exmple.Auth.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service


@Transactional
public class ClientServiceImp implements  ClientInterfaceService{

@Autowired
UserRepository clientRepository;

@Autowired
private PasswordEncoder encoder;

@Autowired
ClientInterfaceMapper clientMapperImp;
    @Override
    public ClientResponses getById(Long id) {

    	User client=clientRepository.findById(id).get();
        ClientResponses res= clientMapperImp.Client_To_ClientResponses(client);
        return  res;


    }

    @Override
    public List<ClientResponses> getAll() {

        List<User> lc=new ArrayList<User>();
        lc=clientRepository.findAll();
        System.out.println(lc);
        List<ClientResponses> lr=new ArrayList<ClientResponses>();
        for(User c:lc){

            ClientResponses cc=new ClientResponses();
           cc =clientMapperImp.Client_To_ClientResponses(c);

            lr.add(cc);
        }
        return lr;



    }

    @Override
    public void add(ClientRequest req) {

    	User c=  clientMapperImp.ClientRequest_To_Client(req);
     System.out.print(c);
     c.password = encoder.encode("123456");
     c.role = "user";
      clientRepository.save(c);
    }

    @Override
    public void modifier(Long id, ClientRequest res) {

    	User c=clientRepository.findById(id).get();

        if(res.getName()!=null)
            c.setName(res.getName());
        if(res.getAdresse()!=null)
            c.setAdresse(res.getAdresse());
        if(res.getEmail()!=null)
            c.setUsername((res.getEmail()));;

        clientRepository.save(c);
    }

    @Override
    public void supprimer(Long id) {
        clientRepository.deleteById(id);

    }
}
