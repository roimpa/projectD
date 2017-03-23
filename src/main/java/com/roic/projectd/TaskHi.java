/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ruben.impa
 */
public class TaskHi implements Task {

    @Override
    public void doTask() {
        Date date = Calendar.getInstance().getTime();
        
        System.out.println("Test job, " + date);
    }
    
}
