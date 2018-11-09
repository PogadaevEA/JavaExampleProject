package jdev.rest.consume;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by epogadaev on 09.11.2018.
 */
public class RestResponse {
    @Getter @Setter public String[] messages;
    @Getter @Setter public Map<String, String> result;
}
