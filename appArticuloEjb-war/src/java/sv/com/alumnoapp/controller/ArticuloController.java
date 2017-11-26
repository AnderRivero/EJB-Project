package sv.com.alumnoapp.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sv.com.articuloapp.entities.Articulos;
import sv.com.articuloapp.model.ArticulosFacade;

/**
 *
 * @author Alfredo Rivero
 */
@Named(value = "articuloController")
@SessionScoped
public class ArticuloController implements Serializable {

    @EJB
    private ArticulosFacade articulosFacade;
    private Articulos articulo;
    
    
    public ArticuloController() {
        
        this.articulo = new Articulos();
    }

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }
    
    public List<Articulos> listarTodosArticulos(){
        return articulosFacade.findAll();
    }
    
    public String addArticulo(){
        articulosFacade.create(articulo);
        this.articulo = new Articulos();
    
    return "index";
    }
    
    public String prepareEditArticulo(Articulos a){
        this.articulo = a;
   
    return "edit";
    }
    
    public String editArticulo(){
        this.articulosFacade.edit(articulo);
        this.articulo = new Articulos();
    return "index";
    }
    
    public void deleteArticulo(Articulos a){
    this.articulosFacade.remove(a);
    }
}
