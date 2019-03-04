
package fr.yogj.bibliows;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.yogj.bibliows.types.LivreEmpruntType;


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
 *         &lt;element name="livreEmprunt" type="{http://www.yogj.fr/biblioWS/types}LivreEmpruntType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "livreEmprunt"
})
@XmlRootElement(name = "obtenirEmpruntUtilisateurResponse")
public class ObtenirEmpruntUtilisateurResponse {

    protected List<LivreEmpruntType> livreEmprunt;

    /**
     * Gets the value of the livreEmprunt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the livreEmprunt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLivreEmprunt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LivreEmpruntType }
     * 
     * 
     */
    public List<LivreEmpruntType> getLivreEmprunt() {
        if (livreEmprunt == null) {
            livreEmprunt = new ArrayList<LivreEmpruntType>();
        }
        return this.livreEmprunt;
    }

}
