/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.roic.projectd.dao.ValorDao;
import com.roic.projectd.entity.Valor;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ruben.impa
 */
public class TaskD implements Task {

    @Value( "${url.consulta.d}" )
    private String uriConsulta;
    @Value( "${element.libre}" )
    private String elementLibre;
    @Value( "${element.blue}" )
    private String elementBlue;

    @Autowired
    private ValorDao valorDao;
    @Autowired
    private MailSender mailSender;
    
    @Override
    public void doTask() {
    
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uriConsulta, String.class);
        JsonObject resultJson = convertStringToJsonObject(result);
        
        Valor datosGet = valorDao.getLastValor();
        Valor valor = new Valor(resultJson.get(this.elementLibre).getAsString(), resultJson.get(this.elementBlue).getAsString(), Calendar.getInstance().getTime().toString());
        
        if (!valor.equals(datosGet)) {
            valorDao.save(valor);
            sendMail();
            System.out.println("New value: " + valor);
        }
        
        System.out.println("Lista: " + valorDao.getList());
        
    }
    
    private JsonObject convertStringToJsonObject(String string) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(string).getAsJsonObject();
        
        return jsonObject;
    }
    
    private void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("abc@no-mail.com");
        message.setTo("ruben.impa@gmail.com");
        message.setSubject("projectD");
        message.setText("Cambio!!");
        mailSender.send(message);
    }
    
}
