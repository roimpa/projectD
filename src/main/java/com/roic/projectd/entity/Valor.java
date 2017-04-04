/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ruben.impa
 */
@Entity
@Table(name="VALOR")
public class Valor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libre;
    private String blue;
    private String date;

    public Valor() {}
    
    public Valor(String libre, String blue, String date) {
        this.libre = libre;
        this.blue = blue;
        this.date = date;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibre() {
        return libre;
    }

    public void setLibre(String libre) {
        this.libre = libre;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id: " + id + ", libre: " + libre + ", blue: " + blue + ", date: " + date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.libre);
        hash = 53 * hash + Objects.hashCode(this.blue);
        hash = 53 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valor other = (Valor) obj;
        if (!Objects.equals(this.libre, other.libre)) {
            return false;
        }
        if (!Objects.equals(this.blue, other.blue)) {
            return false;
        }
        return true;
    }
    
}
