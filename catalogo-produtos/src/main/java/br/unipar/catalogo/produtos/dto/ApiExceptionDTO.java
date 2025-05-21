package br.unipar.catalogo.produtos.dto;

import java.util.Arrays;
import java.util.List;

public class ApiExceptionDTO {

    private List<String> errorList;

    public ApiExceptionDTO(String message) {
        errorList = Arrays.asList(message);
    }

    public ApiExceptionDTO(List<String> errorList) {
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}