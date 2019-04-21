package svkreml.sitemon.backend.rest;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.*;


@Stateless
@LocalBean
@Path("/restTest")
@Produces("application/json")
@Consumes("application/json")
public class RestTest {

    Integer a = 0;

    @GET
    @Path("/b/{param1}/{param2}")
    public Integer mult(@PathParam("param1") Integer param1, @PathParam("param2") Integer param2) {

        return param1 * param2;
    }
    @GET
    @Path("/a")
    public Integer inc() {

        return a++;
    }

}
