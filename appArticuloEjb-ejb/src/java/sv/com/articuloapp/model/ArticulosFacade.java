/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.articuloapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.articuloapp.entities.Articulos;

/**
 *
 * @author Alfredo Rivero
 */
@Stateless
public class ArticulosFacade extends AbstractFacade<Articulos> {

    @PersistenceContext(unitName = "appArticuloEjb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticulosFacade() {
        super(Articulos.class);
    }
    
}
