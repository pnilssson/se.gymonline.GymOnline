package com.gymonline.jpa.api;

import com.gymonline.jpa.models.User;
import sun.misc.BASE64Decoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
@Provider
public class Auth implements ContainerRequestFilter {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX  = "Basic ";
    private static final String SECURED_URL_PREFIX = "cities";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
            List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader != null && authHeader.size() > 0){
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                byte[] credDecoded = new BASE64Decoder().decodeBuffer((authToken));
                String credentials = new String(credDecoded);
                StringTokenizer tokenizer  = new StringTokenizer(credentials, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                User user = em.find(User.class, username);

                try {
                    if (user.getUserName().equals(username) && user.getUserPassword().equals(generateHashString(user.getUserSalt(), password))){
                        return;
                    }
                }
               catch (NullPointerException e){

            Response accessDenied = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource")
                    .build();
            containerRequestContext.abortWith(accessDenied);
               }
        }
        }
    }

    public String generateRandomSaltString(int targetLength){
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetLength);
        for (int i = 0; i < targetLength; i++){
            int randomLimitedInt = leftLimit
                    + (int) (random.nextFloat()
                    * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private String generateHashString(String salt, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String saltAndPassword = salt + password;
            md.update(saltAndPassword.getBytes());
            byte[] digest = md.digest();
            return byte2String(digest);
        }
        catch(NoSuchAlgorithmException e){
            return null;

        }
    }

    private String byte2String(byte[] bytes){
        StringBuffer hexString = new StringBuffer();
        for(int i = 0; i < bytes.length; i++){
            hexString.append((Integer.toHexString(0xFF & bytes[i])));
        }
        return hexString.toString();
    }
}
