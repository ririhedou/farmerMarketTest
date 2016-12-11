/*
 * Created by Zhen Guo on 2016.12.10  * 
 * Copyright © 2016 Zhen Guo. All rights reserved. * 
 */
package market.mymarket.jsfclasses;

import java.io.IOException;
import market.mymarket.entityclasses.Goodslist;
import market.mymarket.jsfclasses.util.JsfUtil;
import market.mymarket.jsfclasses.util.JsfUtil.PersistAction;
import market.mymarket.sessionbeans.GoodslistFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Guo
 */
@Named("goodslistController")
@SessionScoped

public class GoodslistController implements Serializable {

    /*
    -------------------------------
    Instance Variables (Properties)
    -------------------------------
     */
    // searchID refers to FMID for searching all 
    private Integer searchID;

    /*
    ejbFacade is a reference (pointer) to an object that belongs to the GoodslistFacade class. 
    It is annotated with the @EJB annotation implying that the GlassFish application server, at runtime, 
    will inject in this instance variable, a reference to the @Stateless session bean ejbFacade.
     */    
    @EJB
    private market.mymarket.sessionbeans.GoodslistFacade ejbFacade;
    
    // 'items' is an array containing the object references of Goodslists
    private List<Goodslist> items = null;
    // 'selected' contains the object reference of the selected Goodslist
    private Goodslist selected;
    // 'searchItems' is an array containing the object references of Goodslists found in the search
    private List<Goodslist> searchItems = null;    

    /*
    -----------------------------------------------------
    This is the constructor method invoked to instantiate
    an object from the CompanyController class
    -----------------------------------------------------
     */
    public GoodslistController() {
    }

    /*
    -------------------------
    Getter and Setter Methods
    -------------------------
     */
    public Integer getSearchID() {
        return searchID;
    }

    public void setSearchID(Integer searchID) {
        this.searchID = searchID;
    }
    
    public Goodslist getSelected() {
        return selected;
    }

    public void setSelected(Goodslist selected) {
        this.selected = selected;
    }

    private GoodslistFacade getFacade() {
        return ejbFacade;
    }

    /*
    -----------------------
    Embeddable Primary Keys
    -----------------------
     */    
    protected void setEmbeddableKeys() {
        // Nothing to do if entity does not have any embeddable key.
    }

    protected void initializeEmbeddableKey() {
        // Nothing to do if entity does not have any embeddable key.
    }

    /*
    ----------------
    Instance Methods
    ----------------
     */
    // Create a Goodslist Object
    public Goodslist prepareCreate() {
        // Instantiate a new Company object and store its object reference into instance variable 'selected'
        selected = new Goodslist();
        
        initializeEmbeddableKey();  // Initialize embeddable primary key for the new object
        return selected;            // Return the object reference of the newly created Company object
    }

    // Store the newly created Company object in the database
    public void create() {
        // See the persist method below
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GoodslistCreated"));
        if (!JsfUtil.isValidationFailed()) {    // The CREATE operation is successfully performed   
            items = null;    // Empty the items list
        }
    }

    // Update the company, the object reference of which is stored in the instance variable 'selected'
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GoodslistUpdated"));
    }

    // Delete the company, the object reference of which is stored in the instance variable 'selected'
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GoodslistDeleted"));
        if (!JsfUtil.isValidationFailed()) {    // The DELETE operation is successfully performed
            selected = null; // Remove selection
            items = null;    // Empty the items list
        }
    }

    /*
    If 'items' list is empty, obtain the object references of all of the companies
    in the database, store them in the 'items" array (list), and return them.
     */
    public List<Goodslist> getItems() {
        if (items == null) {
            // GoodslistFacade inherits the findAll() method from the AbstractFacade class
            items = getFacade().findAll();
        }
        return items;
    }

    /**
     * @param persistAction refers to CREATE, EDIT or DELETE action
     * @param successMessage specifies if the action completed successfully or not
     */
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    // The edit method is invoked for both CREATE and UPDATE actions
                    // GoodslistFacade inherits the edit method from the AbstractFacade class
                    getFacade().edit(selected);
                } else {
                    // The remove method is invoked for DELETE action
                    // GoodslistFacade inherits the remove method from the AbstractFacade class
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    /**
     * Returns the object reference of the Goodslist whose primary key = id
     *
     * @param id GLID (primary key)
     * @return the object reference of the Goodslist found
     */
    public Goodslist getGoodslist(java.lang.Integer id) {
        // GoodslistFacade inherits the find(id) method from the AbstractFacade class
        return getFacade().find(id);
    }

    /*
    Obtain the object references of all of the Goodslists in the database
    and return them in an array (list).
     */
    public List<Goodslist> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    /*
    Obtain the object references of all of the Goodslists in the database
    and return them in an array (list).
     */
    public List<Goodslist> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /*
    Return the list of object references of all those companies where 
    the search string 'searchString' entered by the user is contained in the searchField.
     */
    public List<Goodslist> getSearchItems() {
        // Return the list of object references of all those Goodslists where 
        // Farmer's Market ID equals to FarmController.selected.fmid
        return getFacade().fmidQuery(searchID);
    }
     
    
    /**
     * @SessionScoped enables to preserve the values of the instance variables for the SearchResults.xhtml page to access.
     *
     * @param actionEvent refers to clicking the Submit button
     * @throws IOException if the page to be redirected to cannot be found
     */
    public void search(ActionEvent actionEvent) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("GoodsList.xhtml");
    }

    /*
     * Faces Converter is an interface describing a Java class that can perform Object-to-String and
     * String-to-Object conversions between model data objects and a String representation of those
     * objects that is suitable for rendering.
     */
    @FacesConverter(forClass = Goodslist.class)
    public static class GoodslistControllerConverter implements Converter {

        /*
        Convert the specified string value, which is associated with the specified UIComponent, 
        into a model data object that is appropriate for being stored during the 
        Apply Request Values phase of the request processing life cycle.
         */
        /**
         * @param facesContext FacesContext for the request being processed
         * @param component UIComponent with which this model object value is associated
         * @param value String value to be converted (may be null)
         * @return Null if the value to convert is null; otherwise, the result of the conversion
         */
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GoodslistController controller = (GoodslistController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "goodslistController");
            return controller.getGoodslist(getKey(value));
        }

        /**
         * Given the String representation of the key, it returns the actual key of type Long
         *
         * @param value String representation of the key
         * @return Actual key of type Long
         */
        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        /**
         * Given the actual key of type Long, it returns the String representation of the key
         *
         * @param value Actual key of type Long
         * @return String representation of the key
         */
        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        /*
        Convert the specified model object value, which is associated with the specified UIComponent, 
        into a String that is suitable for being included in the response generated during the 
        Render Response phase of the request processing life cycle.
        */
        /**
         * @param facesContext FacesContext for the request being processed
         * @param component UIComponent with which this model object value is associated
         * @param object Model object value to be converted (may be null)
         * @return A zero-length String if value is null; otherwise, the result of the conversion
         */
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Goodslist) {
                Goodslist o = (Goodslist) object;
                return getStringKey(o.getGlid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Goodslist.class.getName()});
                return null;
            }
        }

    }

}
