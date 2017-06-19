package ts.serviceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ts.model.*;


@Path("/Company")
public interface ICompanyService {
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getAirport/{id}")
    Response getAirport(@PathParam("id") int id);

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogin/{username}/{pwd}")
    Response doLogin(@PathParam("username") String username, @PathParam("pwd") String pwd);

    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/register")
    Company register(Company company);




}
