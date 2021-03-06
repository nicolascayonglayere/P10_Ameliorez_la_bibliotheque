
package fr.yogj.bibliows;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.yogj.bibliows package. 
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

    private final static QName _DeconnexionResponse_QNAME = new QName("http://yogj.fr/biblioWS/", "deconnexionResponse");
    private final static QName _ListNouveautes_QNAME = new QName("http://yogj.fr/biblioWS/", "listNouveautes");
    private final static QName _ListRetardataires_QNAME = new QName("http://yogj.fr/biblioWS/", "listRetardataires");
    private final static QName _ListeAlerteRetour_QNAME = new QName("http://yogj.fr/biblioWS/", "listeAlerteRetour");
    private final static QName _ModifRappelOptionResponse_QNAME = new QName("http://yogj.fr/biblioWS/", "modifRappelOptionResponse");
    private final static QName _ListeRappelRetour_QNAME = new QName("http://yogj.fr/biblioWS/", "listeRappelRetour");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.yogj.bibliows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LoginFault }
     * 
     */
    public LoginFault createLoginFault() {
        return new LoginFault();
    }

    /**
     * Create an instance of {@link Deconnexion }
     * 
     */
    public Deconnexion createDeconnexion() {
        return new Deconnexion();
    }

    /**
     * Create an instance of {@link DeconnexionFault }
     * 
     */
    public DeconnexionFault createDeconnexionFault() {
        return new DeconnexionFault();
    }

    /**
     * Create an instance of {@link ListNouveautesResponse }
     * 
     */
    public ListNouveautesResponse createListNouveautesResponse() {
        return new ListNouveautesResponse();
    }

    /**
     * Create an instance of {@link RechercheOuvrage }
     * 
     */
    public RechercheOuvrage createRechercheOuvrage() {
        return new RechercheOuvrage();
    }

    /**
     * Create an instance of {@link RechercheOuvrageResponse }
     * 
     */
    public RechercheOuvrageResponse createRechercheOuvrageResponse() {
        return new RechercheOuvrageResponse();
    }

    /**
     * Create an instance of {@link DetailsOuvrageFault }
     * 
     */
    public DetailsOuvrageFault createDetailsOuvrageFault() {
        return new DetailsOuvrageFault();
    }

    /**
     * Create an instance of {@link EmpruntOuvrage }
     * 
     */
    public EmpruntOuvrage createEmpruntOuvrage() {
        return new EmpruntOuvrage();
    }

    /**
     * Create an instance of {@link EmpruntOuvrageResponse }
     * 
     */
    public EmpruntOuvrageResponse createEmpruntOuvrageResponse() {
        return new EmpruntOuvrageResponse();
    }

    /**
     * Create an instance of {@link EmpruntOuvrageFault }
     * 
     */
    public EmpruntOuvrageFault createEmpruntOuvrageFault() {
        return new EmpruntOuvrageFault();
    }

    /**
     * Create an instance of {@link RetourOuvrage }
     * 
     */
    public RetourOuvrage createRetourOuvrage() {
        return new RetourOuvrage();
    }

    /**
     * Create an instance of {@link RetourOuvrageResponse }
     * 
     */
    public RetourOuvrageResponse createRetourOuvrageResponse() {
        return new RetourOuvrageResponse();
    }

    /**
     * Create an instance of {@link RetourOuvrageFault }
     * 
     */
    public RetourOuvrageFault createRetourOuvrageFault() {
        return new RetourOuvrageFault();
    }

    /**
     * Create an instance of {@link RetourOuvrageFault1 }
     * 
     */
    public RetourOuvrageFault1 createRetourOuvrageFault1() {
        return new RetourOuvrageFault1();
    }

    /**
     * Create an instance of {@link ProlongationOuvrage }
     * 
     */
    public ProlongationOuvrage createProlongationOuvrage() {
        return new ProlongationOuvrage();
    }

    /**
     * Create an instance of {@link ProlongationOuvrageResponse }
     * 
     */
    public ProlongationOuvrageResponse createProlongationOuvrageResponse() {
        return new ProlongationOuvrageResponse();
    }

    /**
     * Create an instance of {@link ProlongationOuvrageFault }
     * 
     */
    public ProlongationOuvrageFault createProlongationOuvrageFault() {
        return new ProlongationOuvrageFault();
    }

    /**
     * Create an instance of {@link ProlongationOuvrageFault1 }
     * 
     */
    public ProlongationOuvrageFault1 createProlongationOuvrageFault1() {
        return new ProlongationOuvrageFault1();
    }

    /**
     * Create an instance of {@link ListRetardatairesResponse }
     * 
     */
    public ListRetardatairesResponse createListRetardatairesResponse() {
        return new ListRetardatairesResponse();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntUtilisateur }
     * 
     */
    public ObtenirEmpruntUtilisateur createObtenirEmpruntUtilisateur() {
        return new ObtenirEmpruntUtilisateur();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntUtilisateurResponse }
     * 
     */
    public ObtenirEmpruntUtilisateurResponse createObtenirEmpruntUtilisateurResponse() {
        return new ObtenirEmpruntUtilisateurResponse();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntUtilisateurFault }
     * 
     */
    public ObtenirEmpruntUtilisateurFault createObtenirEmpruntUtilisateurFault() {
        return new ObtenirEmpruntUtilisateurFault();
    }

    /**
     * Create an instance of {@link ObtenirReservationUtilisateur }
     * 
     */
    public ObtenirReservationUtilisateur createObtenirReservationUtilisateur() {
        return new ObtenirReservationUtilisateur();
    }

    /**
     * Create an instance of {@link ObtenirReservationUtilisateurResponse }
     * 
     */
    public ObtenirReservationUtilisateurResponse createObtenirReservationUtilisateurResponse() {
        return new ObtenirReservationUtilisateurResponse();
    }

    /**
     * Create an instance of {@link ObtenirReservationUtilisateurFault }
     * 
     */
    public ObtenirReservationUtilisateurFault createObtenirReservationUtilisateurFault() {
        return new ObtenirReservationUtilisateurFault();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntLivre }
     * 
     */
    public ObtenirEmpruntLivre createObtenirEmpruntLivre() {
        return new ObtenirEmpruntLivre();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntLivreResponse }
     * 
     */
    public ObtenirEmpruntLivreResponse createObtenirEmpruntLivreResponse() {
        return new ObtenirEmpruntLivreResponse();
    }

    /**
     * Create an instance of {@link ObtenirEmpruntLivreFault1 }
     * 
     */
    public ObtenirEmpruntLivreFault1 createObtenirEmpruntLivreFault1() {
        return new ObtenirEmpruntLivreFault1();
    }

    /**
     * Create an instance of {@link AnnulerReservation }
     * 
     */
    public AnnulerReservation createAnnulerReservation() {
        return new AnnulerReservation();
    }

    /**
     * Create an instance of {@link AnnulerReservationResponse }
     * 
     */
    public AnnulerReservationResponse createAnnulerReservationResponse() {
        return new AnnulerReservationResponse();
    }

    /**
     * Create an instance of {@link AnnulerReservationFault }
     * 
     */
    public AnnulerReservationFault createAnnulerReservationFault() {
        return new AnnulerReservationFault();
    }

    /**
     * Create an instance of {@link ReserverOuvrage }
     * 
     */
    public ReserverOuvrage createReserverOuvrage() {
        return new ReserverOuvrage();
    }

    /**
     * Create an instance of {@link ReserverOuvrageResponse }
     * 
     */
    public ReserverOuvrageResponse createReserverOuvrageResponse() {
        return new ReserverOuvrageResponse();
    }

    /**
     * Create an instance of {@link ReserverOuvrageFault }
     * 
     */
    public ReserverOuvrageFault createReserverOuvrageFault() {
        return new ReserverOuvrageFault();
    }

    /**
     * Create an instance of {@link ListeAlerteRetourResponse }
     * 
     */
    public ListeAlerteRetourResponse createListeAlerteRetourResponse() {
        return new ListeAlerteRetourResponse();
    }

    /**
     * Create an instance of {@link ObtenirReservationOuvrage }
     * 
     */
    public ObtenirReservationOuvrage createObtenirReservationOuvrage() {
        return new ObtenirReservationOuvrage();
    }

    /**
     * Create an instance of {@link ObtenirReservationOuvrageResponse }
     * 
     */
    public ObtenirReservationOuvrageResponse createObtenirReservationOuvrageResponse() {
        return new ObtenirReservationOuvrageResponse();
    }

    /**
     * Create an instance of {@link ModifRappelOption }
     * 
     */
    public ModifRappelOption createModifRappelOption() {
        return new ModifRappelOption();
    }

    /**
     * Create an instance of {@link ListeRappelRetourResponse }
     * 
     */
    public ListeRappelRetourResponse createListeRappelRetourResponse() {
        return new ListeRappelRetourResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "deconnexionResponse")
    public JAXBElement<String> createDeconnexionResponse(String value) {
        return new JAXBElement<String>(_DeconnexionResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "listNouveautes")
    public JAXBElement<String> createListNouveautes(String value) {
        return new JAXBElement<String>(_ListNouveautes_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "listRetardataires")
    public JAXBElement<String> createListRetardataires(String value) {
        return new JAXBElement<String>(_ListRetardataires_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "listeAlerteRetour")
    public JAXBElement<String> createListeAlerteRetour(String value) {
        return new JAXBElement<String>(_ListeAlerteRetour_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "modifRappelOptionResponse")
    public JAXBElement<String> createModifRappelOptionResponse(String value) {
        return new JAXBElement<String>(_ModifRappelOptionResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yogj.fr/biblioWS/", name = "listeRappelRetour")
    public JAXBElement<String> createListeRappelRetour(String value) {
        return new JAXBElement<String>(_ListeRappelRetour_QNAME, String.class, null, value);
    }

}
