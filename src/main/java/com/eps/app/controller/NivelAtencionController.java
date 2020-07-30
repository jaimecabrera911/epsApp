package com.eps.app.controller;

import com.eps.app.entity.NivelAtencion;
import com.eps.app.controller.util.JsfUtil;
import com.eps.app.controller.util.JsfUtil.PersistAction;
import com.eps.app.facade.NivelAtencionFacade;

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

@Named("nivelAtencionController")
@SessionScoped
public class NivelAtencionController implements Serializable {

    @EJB
    private com.eps.app.facade.NivelAtencionFacade ejbFacade;
    private List<NivelAtencion> items = null;
    private NivelAtencion selected;

    public NivelAtencionController() {
    }

    public NivelAtencion getSelected() {
        return selected;
    }

    public void setSelected(NivelAtencion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private NivelAtencionFacade getFacade() {
        return ejbFacade;
    }

    public NivelAtencion prepareCreate() {
        selected = new NivelAtencion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("NivelAtencionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("NivelAtencionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("NivelAtencionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<NivelAtencion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
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

    public NivelAtencion getNivelAtencion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<NivelAtencion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NivelAtencion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NivelAtencion.class)
    public static class NivelAtencionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NivelAtencionController controller = (NivelAtencionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "nivelAtencionController");
            return controller.getNivelAtencion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NivelAtencion) {
                NivelAtencion o = (NivelAtencion) object;
                return getStringKey(o.getIdNivelAtencion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NivelAtencion.class.getName()});
                return null;
            }
        }

    }

}
