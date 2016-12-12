/*
 * Created by Zhen Guo on 2016.12.10  * 
 * Copyright © 2016 Zhen Guo. All rights reserved. * 
 */
package market.mymarket.jsfclasses;

import market.mymarket.entityclasses.Farm;
import market.mymarket.jsfclasses.util.JsfUtil;
import market.mymarket.jsfclasses.util.JsfUtil.PersistAction;
import market.mymarket.sessionbeans.FarmFacade;

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

/**
 *
 * @author Guo
 */
@Named("farmController")
@SessionScoped

public class FarmController implements Serializable {

    /*
    -------------------------------
    Instance Variables (Properties)
    -------------------------------
     */
    /*
    FarmFacade is a reference (pointer) to an object that belongs to the FarmFacade class. 
    It is annotated with the @EJB annotation implying that the GlassFish application server, at runtime, 
    will inject in this instance variable, a reference to the @Stateless session bean farmFacade.
     */    
    @EJB
    private market.mymarket.sessionbeans.FarmFacade ejbFacade;
    // 'items' is an array containing the object references of Farm
    private List<Farm> items = null;
    // 'selected' contains the object reference of the selected Farm
    private Farm selected;

    /*
    -----------------------------------------------------
    This is the constructor method invoked to instantiate
    an object from the FarmController class
    -----------------------------------------------------
     */
    public FarmController() {
    }
    
    /*
    -------------------------
    Getter and Setter Methods
    -------------------------
     */
    public Farm getSelected() {
        return selected;
    }

    public void setSelected(Farm selected) {
        this.selected = selected;
    }

    private FarmFacade getFacade() {
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
    // Create a Fram Object
    public Farm prepareCreate() {
        // Instantiate a new Farm object and store its object reference into instance variable 'selected'
        selected = new Farm();
        initializeEmbeddableKey();  // Initialize embeddable primary key for the new object
        return selected;            // Return the object reference of the newly created Company object
    }

    // Store the newly created Company object in the database
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FarmCreated"));
        if (!JsfUtil.isValidationFailed()) {    // The CREATE operation is successfully performed
            items = null;    // Empty the items list
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FarmUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FarmDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    /*
    If 'items' list is empty, obtain the object references of all of the companies
    in the database, store them in the 'items" array (list), and return them.
     */    
    public List<Farm> getItems() {
        if (items == null) {
            // FarmFacade inherits the findAll() method from the AbstractFacade class
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
                    // FarmFacade inherits the edit method from the AbstractFacade class
                    getFacade().edit(selected);
                } else {
                    // The remove method is invoked for DELETE action
                    // FarmFacade inherits the remove method from the AbstractFacade class
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
     * Returns the object reference of the Farm whose primary key = id
     *
     * @param id Company's id (primary key)
     * @return the object reference of the Company found
     */
    public Farm getFarm(java.lang.String id) {
        // CompanyFacade inherits the find(id) method from the AbstractFacade class
        return getFacade().find(id);
    }

    /*
    Obtain the object references of all of the companies in the database
    and return them in an array (list).
     */
    public List<Farm> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    /*
    Obtain the object references of all of the companies in the database
    and return them in an array (list).
     */
    public List<Farm> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /*
     * Faces Converter is an interface describing a Java class that can perform Object-to-String and
     * String-to-Object conversions between model data objects and a String representation of those
     * objects that is suitable for rendering.
     */
    @FacesConverter(forClass = Farm.class)
    public static class FarmControllerConverter implements Converter {

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
            FarmController controller = (FarmController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "farmController");
            return controller.getFarm(getKey(value));
        }

        /**
         * Given the String representation of the key, it returns the actual key of type Long
         *
         * @param value String representation of the key
         * @return Actual key of type Long
         */
        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        /**
         * Given the actual key of type Long, it returns the String representation of the key
         *
         * @param value Actual key of type Long
         * @return String representation of the key
         */
        String getStringKey(java.lang.String value) {
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
            if (object instanceof Farm) {
                Farm o = (Farm) object;
                return getStringKey(o.getFmid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Farm.class.getName()});
                return null;
            }
        }

    }

}
