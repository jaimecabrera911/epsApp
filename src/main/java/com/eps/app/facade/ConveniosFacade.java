/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.app.facade;

import com.eps.app.entity.Convenios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class ConveniosFacade extends AbstractFacade<Convenios> {

    @PersistenceContext(unitName = "com_eps-app_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConveniosFacade() {
        super(Convenios.class);
    }
    
}
