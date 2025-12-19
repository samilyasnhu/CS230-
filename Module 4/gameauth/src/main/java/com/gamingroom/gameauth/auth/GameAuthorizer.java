package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

/**
 * GameAuthorizer handles role-based access control (RBAC)
 * by checking whether the authenticated user possesses
 * the required role for an endpoint.
 */
public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {
        /*
         * Check if the user has the required role.
         * This follows the BasicAuth Security Example logic.
         *
         * Returns true if role matches the role(s) assigned
         * to the authenticated user.
         */
        return user != null && user.getRoles() != null && user.getRoles().contains(role);
    }
}
