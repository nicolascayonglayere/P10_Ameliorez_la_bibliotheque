
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-05-08T11:10:30.787+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "obtenirEmpruntUtilisateurFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class ObtenirEmpruntUtilisateurFault_Exception extends Exception {

    private fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault obtenirEmpruntUtilisateurFault;

    public ObtenirEmpruntUtilisateurFault_Exception() {
        super();
    }

    public ObtenirEmpruntUtilisateurFault_Exception(String message) {
        super(message);
    }

    public ObtenirEmpruntUtilisateurFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ObtenirEmpruntUtilisateurFault_Exception(String message, fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault obtenirEmpruntUtilisateurFault) {
        super(message);
        this.obtenirEmpruntUtilisateurFault = obtenirEmpruntUtilisateurFault;
    }

    public ObtenirEmpruntUtilisateurFault_Exception(String message, fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault obtenirEmpruntUtilisateurFault, java.lang.Throwable cause) {
        super(message, cause);
        this.obtenirEmpruntUtilisateurFault = obtenirEmpruntUtilisateurFault;
    }

    public fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault getFaultInfo() {
        return this.obtenirEmpruntUtilisateurFault;
    }
}
