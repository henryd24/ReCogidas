/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Henry Daniel
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "ReCogidasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
     public Users login(Users user){
        String consulta;
        consulta  = "FROM Users u WHERE u.username = ?1 and u.password = ?2";//Busqueda de los datos que se ingresan en la base de datos
        Query query = em.createQuery(consulta);
        query.setParameter(1, user.getUsername());
        query.setParameter(2, user.getPassword());
        
        List<Users> lista = query.getResultList();
        if (lista.isEmpty()) {
            return null;
        }else{
            System.out.println("encontrado");
            return lista.get(0);
        }
        
    }

    
}
