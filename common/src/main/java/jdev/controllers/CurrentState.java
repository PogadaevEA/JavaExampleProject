package jdev.controllers;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by epogadaev on 09.11.2018.
 */
public class CurrentState {
    @Getter @Setter private final long id;
    @Getter @Setter private final String content;

    public CurrentState(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
