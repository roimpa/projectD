/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roic.projectd.dao;

import com.roic.projectd.entity.Valor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ruben.impa
 */
@Repository
@Transactional
public class ValorDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public void save(Valor datos) {
        Session session = this.sessionFactory.openSession();
        session.persist(datos);
    }
    
    public Valor getLastValor() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Valor order by id DESC");
        query.setMaxResults(1);
        Valor datosRow = (Valor)query.uniqueResult();
        return datosRow;
    }
    
    public List<Valor> getList() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Valor");
        
        return query.list();
    }
    
}
