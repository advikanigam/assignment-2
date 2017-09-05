package controllers;

import javax.ws.rs.*;

@Path("/netid")
public class netidController {
    @GET
    public String getNetId() {
        return "an556";
    }
}
