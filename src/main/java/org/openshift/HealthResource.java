package org.openshift;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Random;

@RequestScoped
@Path("/health")
public class HealthResource {

    @GET()
    @Produces("application/json")
    public HashMap<String, String> getHealth() {
        HashMap<String, String> theInsult = new HashMap<>();
        theInsult.put("health", new InsultGenerator().generateInsult());

        int i = new Random().nextInt(10);
        System.out.println(i);

        if (i > 5) {
            throw new RuntimeException("ICH BIN EINE EXCEPTION, Nummer: " + i);
        }
        return new HashMap<>();
    }

}
