/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.app.facade;

import com.eps.app.entity.Localidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class LocalidadesFacade extends AbstractFacade<Localidades> {

    @PersistenceContext(unitName = "com_eps-app_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadesFacade() {
        super(Localidades.class);
    }
    
}
