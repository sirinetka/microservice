package com.exmple.Auth;

import com.example.dto.ClientRequest;
import com.example.dto.ClientResponses;
import com.exmple.Auth.User;

public interface ClientInterfaceMapper {

    public User ClientRequest_To_Client(ClientRequest req);

    public ClientResponses Client_To_ClientResponses(User c);

}
