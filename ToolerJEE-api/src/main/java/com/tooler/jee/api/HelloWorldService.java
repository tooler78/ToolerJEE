package com.tooler.jee.api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * A simple example of how to setup a JAX-WS Web Service. It can say hello to everyone or to someone in particular.
 *
 * @author lnewson@redhat.com
 */

@WebService(targetNamespace = "http://www.tooler.com/webservice/HelloWorld")
public interface HelloWorldService {

    /**
     * Say hello as a response
     *
     * @return A simple hello world message
     */
    @WebMethod
    public String sayHello();

    /**
     * Say hello to someone precisely
     *
     * @param name The name of the person to say hello to
     * @return the number of current bookings
     */
    @WebMethod
    public String sayHelloToName(String name);

    /**
     * Say hello to a list of people
     *
     * @param names The list of names to say hello to
     * @return the number of current bookings
     */
    @WebMethod
    public String sayHelloToNames(List<String> names);
}

