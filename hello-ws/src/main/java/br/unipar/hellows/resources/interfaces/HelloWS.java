package br.unipar.hellows.resources.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface HelloWS {

    @WebMethod
    String helloWorld(String name);

    @WebMethod
    int somar(int a, int b);
}
