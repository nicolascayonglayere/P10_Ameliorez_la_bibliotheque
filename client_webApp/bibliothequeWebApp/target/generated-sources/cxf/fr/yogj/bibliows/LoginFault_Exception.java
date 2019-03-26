
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-26T10:45:28.031+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "loginFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class LoginFault_Exception extends Exception {

    private fr.yogj.bibliows.LoginFault loginFault;

    public LoginFault_Exception() {
        super();
    }

    public LoginFault_Exception(String message) {
        super(message);
    }

    public LoginFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public LoginFault_Exception(String message, fr.yogj.bibliows.LoginFault loginFault) {
        super(message);
        this.loginFault = loginFault;
    }

    public LoginFault_Exception(String message, fr.yogj.bibliows.LoginFault loginFault, java.lang.Throwable cause) {
        super(message, cause);
        this.loginFault = loginFault;
    }

    public fr.yogj.bibliows.LoginFault getFaultInfo() {
        return this.loginFault;
    }
}
