package fr.yogj.bibliows;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-20T16:15:37.810+01:00
 * Generated source version: 3.2.5
 *
 */
@WebServiceClient(name = "biblioWS",
                  wsdlLocation = "classpath:biblioWS.wsdl",
                  targetNamespace = "http://yogj.fr/biblioWS/")
public class BiblioWS_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://yogj.fr/biblioWS/", "biblioWS");
    public final static QName BiblioWSSOAP = new QName("http://yogj.fr/biblioWS/", "biblioWSSOAP");
    static {
        URL url = BiblioWS_Service.class.getClassLoader().getResource("biblioWS.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(BiblioWS_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:biblioWS.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BiblioWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BiblioWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BiblioWS_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BiblioWS_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BiblioWS_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BiblioWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BiblioWS
     */
    @WebEndpoint(name = "biblioWSSOAP")
    public BiblioWS getBiblioWSSOAP() {
        return super.getPort(BiblioWSSOAP, BiblioWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BiblioWS
     */
    @WebEndpoint(name = "biblioWSSOAP")
    public BiblioWS getBiblioWSSOAP(WebServiceFeature... features) {
        return super.getPort(BiblioWSSOAP, BiblioWS.class, features);
    }

}
