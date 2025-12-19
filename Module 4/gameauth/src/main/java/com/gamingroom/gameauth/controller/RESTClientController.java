package com.gamingroom.gameauth.controller;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gamingroom.gameauth.representations.GameUserInfo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/client")
public class RESTClientController {

    private Client client;

    public RESTClientController(Client client) {
        this.client = client;
    }

    @GET
    @Path("/gameusers")
    public Response getGameUsers() {
        WebTarget webTarget = client.target("http://localhost:8080/gameusers");

        Invocation.Builder invocationBuilder = webTarget
                .register(HttpAuthenticationFeature.basic("admin", "password"))
                .request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        ArrayList<?> gameusers = response.readEntity(ArrayList.class);

        return Response.ok(gameusers).build();
    }

    @GET
    @Path("/gameusers/{id}")
    public Response getGameUserById(@PathParam("id") int id) {
        WebTarget webTarget = client.target("http://localhost:8080/gameusers/" + id);

        Invocation.Builder invocationBuilder = webTarget
                .register(HttpAuthenticationFeature.basic("admin", "password"))
                .request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        GameUserInfo gameUserInfo = response.readEntity(GameUserInfo.class);

        return Response.ok(gameUserInfo).build();
    }
}
