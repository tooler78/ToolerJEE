package com.tooler.jee;

import com.tooler.jee.api.HelloWorldService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the HelloWorld JAX-WS Web Service.
 */
@WebService(serviceName = "HelloWorldService", portName = "HelloWorld", name = "HelloWorld", endpointInterface = "com.tooler.jee.api.HelloWorldService", targetNamespace = "http://www.tooler.com/webservice/HelloWorld")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    @Override
    public String sayHelloToName(final String name) {
        final List<String> names = new ArrayList<String>();
        names.add(name);

        return sayHelloToNames(names);
    }

    @Override
    public String sayHelloToNames(final List<String> names) {
        return "Hello " + createNameListString(names);
    }

    /**
     * Creates a list of names separated by commas or an and symbol if its the last separation. This is then used to say hello to
     * the list of names.
     *
     * i.e. if the input was {John, Mary, Luke} the output would be John, Mary & Luke
     *
     * @param names A list of names
     * @return The list of names separated as described above.
     */
    private String createNameListString(final List<String> names) {
        if (names == null || names.isEmpty()) {
            return "Anonymous!";
        }

        final StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i != 0 && i != names.size() - 1)
                nameBuilder.append(", ");
            else if (i != 0 && i == names.size() - 1)
                nameBuilder.append(" & ");

            nameBuilder.append(names.get(i));
        }

        nameBuilder.append("!");

        return nameBuilder.toString();
    }
}