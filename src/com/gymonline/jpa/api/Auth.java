package com.gymonline.jpa.api;

import sun.misc.BASE64Decoder;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import java.util.List;
import java.util.StringTokenizer;
@Provider
public class Auth implements ContainerRequestFilter {

    private static final  String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final  String AUTHORIZATION_HEADER_PREFIX     = "Basic ";
    private static final  String SECURED_URL_PREFIX = "cities";
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){


            List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader != null && authHeader.size() > 0){
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                byte[] credDecoded = new BASE64Decoder().decodeBuffer(String.valueOf(authToken));
                String credenLials = new String(credDecoded);
                StringTokenizer tokenizer  = new StringTokenizer(credenLials, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                if ("user".equals(username) && "password".equals(password)){
                    return;
                }

            }
            Response accesDenied = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot acces the resource")
                    .build();
            containerRequestContext.abortWith(accesDenied);
        }
    }
}
