package com.gamingroom.gameauth.controller;

import io.dropwizard.auth.Auth;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gamingroom.gameauth.auth.GameUser;
import com.gamingroom.gameauth.dao.GameUserDB;
import com.gamingroom.gameauth.representations.GameUserInfo;

@Path("/gameusers")  
@Produces(MediaType.APPLICATION_JSON)
public class GameUserRESTController {

    private final Validator validator;

    public GameUserRESTController(Validator validator) {
        this.validator = validator;
    }

    // Anyone can access this BEFORE security enforcement
    @PermitAll
    @GET
    public Response getGameUsers(@Auth GameUser user) {
        return Response.ok(GameUserDB.getGameUsers()).build();
    }

    @RolesAllowed("USER")
    @GET
    @Path("/{id}")
    public Response getGameUserById(@PathParam("id") Integer id, @Auth GameUser user) {
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
        if (gameUserInfo != null)
            return Response.ok(gameUserInfo).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }

    @RolesAllowed("ADMIN")
    @POST
    public Response createGameUser(GameUserInfo gameUserInfo, @Auth GameUser user) throws URISyntaxException {
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo existingUser = GameUserDB.getGameUser(gameUserInfo.getId());

        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }

        if (existingUser != null) {
            GameUserDB.updateGameUser(gameUserInfo.getId(), gameUserInfo);
            return Response.created(new URI("/gameusers/" + gameUserInfo.getId())).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateGameUserById(@PathParam("id") Integer id, GameUserInfo gameUserInfo) {
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo existingUser = GameUserDB.getGameUser(gameUserInfo.getId());

        if (violations.size() > 0) {
            ArrayList<String> messages = new ArrayList<>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                messages.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(messages).build();
        }

        if (existingUser != null) {
            gameUserInfo.setId(id);
            GameUserDB.updateGameUser(id, gameUserInfo);
            return Response.ok(gameUserInfo).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeGameUserById(@PathParam("id") Integer id) {
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
        if (gameUserInfo != null) {
            GameUserDB.removeGameUser(id);
            return Response.ok().build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
