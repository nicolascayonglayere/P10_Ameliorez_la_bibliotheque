
package fr.yogj.bibliows;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.UtilisateurType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="utilisateur" type="{http://www.yogj.fr/biblioWS/types}UtilisateurType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="coordonnee" type="{http://www.yogj.fr/biblioWS/types}CoordonneeUtilisateurType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "utilisateur",
    "coordonnee"
})
@XmlRootElement(name = "listRetardatairesResponse")
public class ListRetardatairesResponse {

    @XmlElement(required = true)
    protected List<UtilisateurType> utilisateur;
    @XmlElement(required = true)
    protected CoordonneeUtilisateurType coordonnee;

    /**
     * Gets the value of the utilisateur property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utilisateur property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtilisateur().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UtilisateurType }
     * 
     * 
     */
    public List<UtilisateurType> getUtilisateur() {
        if (utilisateur == null) {
            utilisateur = new ArrayList<UtilisateurType>();
        }
        return this.utilisateur;
    }

    /**
     * Obtient la valeur de la propriété coordonnee.
     * 
     * @return
     *     possible object is
     *     {@link CoordonneeUtilisateurType }
     *     
     */
    public CoordonneeUtilisateurType getCoordonnee() {
        return coordonnee;
    }

    /**
     * Définit la valeur de la propriété coordonnee.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordonneeUtilisateurType }
     *     
     */
    public void setCoordonnee(CoordonneeUtilisateurType value) {
        this.coordonnee = value;
    }

}
