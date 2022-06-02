package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Value("${app.message}")
    private String appMessage;

    //Variável de ambiente passada com valor default
    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentURL;

    @GetMapping("/message")
    public String getAppMessage(){
     return appMessage;
    }

    @GetMapping("/env-db")
    public String getDbEnvironmentURL(){return "A seguinte variável de ambiente foi passada: " + dbEnvironmentURL;}
}
