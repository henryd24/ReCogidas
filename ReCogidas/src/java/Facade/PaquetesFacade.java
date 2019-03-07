/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Paquetes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henry Daniel
 */
@Stateless
public class PaquetesFacade extends AbstractFacade<Paquetes> {

    @PersistenceContext(unitName = "ReCogidasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaquetesFacade() {
        super(Paquetes.class);
    }
    
}
