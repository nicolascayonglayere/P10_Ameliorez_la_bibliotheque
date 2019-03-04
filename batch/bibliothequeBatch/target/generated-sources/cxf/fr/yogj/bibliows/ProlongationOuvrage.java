
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="idEmprunt" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "idEmprunt"
})
@XmlRootElement(name = "prolongationOuvrage")
public class ProlongationOuvrage {

    protected int idEmprunt;

    /**
     * Obtient la valeur de la propriété idEmprunt.
     * 
     */
    public int getIdEmprunt() {
        return idEmprunt;
    }

    /**
     * Définit la valeur de la propriété idEmprunt.
     * 
     */
    public void setIdEmprunt(int value) {
        this.idEmprunt = value;
    }

}
