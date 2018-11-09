package jdev.controllers;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by epogadaev on 09.11.2018.
 */
public class Response {

    @Getter @Setter String message;
    @Getter @Setter boolean success;

    public Response(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

}
