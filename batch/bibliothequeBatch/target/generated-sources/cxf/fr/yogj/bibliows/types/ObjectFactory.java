
package fr.yogj.bibliows.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.yogj.bibliows.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.yogj.bibliows.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UtilisateurType }
     * 
     */
    public UtilisateurType createUtilisateurType() {
        return new UtilisateurType();
    }

    /**
     * Create an instance of {@link CoordonneeUtilisateurType }
     * 
     */
    public CoordonneeUtilisateurType createCoordonneeUtilisateurType() {
        return new CoordonneeUtilisateurType();
    }

    /**
     * Create an instance of {@link LivreEmpruntType }
     * 
     */
    public LivreEmpruntType createLivreEmpruntType() {
        return new LivreEmpruntType();
    }

    /**
     * Create an instance of {@link LivreType }
     * 
     */
    public LivreType createLivreType() {
        return new LivreType();
    }

    /**
     * Create an instance of {@link AuteurType }
     * 
     */
    public AuteurType createAuteurType() {
        return new AuteurType();
    }

    /**
     * Create an instance of {@link EditeurType }
     * 
     */
    public EditeurType createEditeurType() {
        return new EditeurType();
    }

}
