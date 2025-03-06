package br.unipar.hellows.resources;

import br.unipar.hellows.resources.interfaces.HelloWS;
import jakarta.jws.WebService;

@WebService(endpointInterface = "br.unipar.hellows.resources.interfaces.HelloWS")
public class HelloWSImp implements HelloWS {

    @Override
    public String helloWorld(String name) {
        System.out.println("CHEGOU NO WSSSSSSSSSSSSSSSSSSS");
        return "Bem vindo ao mundo soap, " + name + "!";
    }

    @Override
    public int somar(int a, int b) {
        return a + b;
    }


}
