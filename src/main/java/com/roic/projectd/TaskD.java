/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ruben.impa
 */
public class TaskD implements Task {

    @Value( "${url.consulta.d}" )
    private String uriConsulta;
    
    @Override
    public void doTask() {
     
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uriConsulta, String.class);

        System.out.println(result);
    }
    
}
