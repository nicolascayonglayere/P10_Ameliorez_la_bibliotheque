
package fr.yogj.bibliows.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour LivreEmpruntType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="LivreEmpruntType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="emprunteur" type="{http://www.yogj.fr/biblioWS/types}UtilisateurType"/&gt;
 *         &lt;element name="ouvrage" type="{http://www.yogj.fr/biblioWS/types}LivreType"/&gt;
 *         &lt;element name="dateEmprunt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="prolongation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivreEmpruntType", propOrder = {
    "id",
    "emprunteur",
    "ouvrage",
    "dateEmprunt",
    "prolongation"
})
public class LivreEmpruntType {

    protected int id;
    @XmlElement(required = true)
    protected UtilisateurType emprunteur;
    @XmlElement(required = true)
    protected LivreType ouvrage;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEmprunt;
    protected boolean prolongation;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété emprunteur.
     * 
     * @return
     *     possible object is
     *     {@link UtilisateurType }
     *     
     */
    public UtilisateurType getEmprunteur() {
        return emprunteur;
    }

    /**
     * Définit la valeur de la propriété emprunteur.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilisateurType }
     *     
     */
    public void setEmprunteur(UtilisateurType value) {
        this.emprunteur = value;
    }

    /**
     * Obtient la valeur de la propriété ouvrage.
     * 
     * @return
     *     possible object is
     *     {@link LivreType }
     *     
     */
    public LivreType getOuvrage() {
        return ouvrage;
    }

    /**
     * Définit la valeur de la propriété ouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreType }
     *     
     */
    public void setOuvrage(LivreType value) {
        this.ouvrage = value;
    }

    /**
     * Obtient la valeur de la propriété dateEmprunt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEmprunt() {
        return dateEmprunt;
    }

    /**
     * Définit la valeur de la propriété dateEmprunt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEmprunt(XMLGregorianCalendar value) {
        this.dateEmprunt = value;
    }

    /**
     * Obtient la valeur de la propriété prolongation.
     * 
     */
    public boolean isProlongation() {
        return prolongation;
    }

    /**
     * Définit la valeur de la propriété prolongation.
     * 
     */
    public void setProlongation(boolean value) {
        this.prolongation = value;
    }

}
