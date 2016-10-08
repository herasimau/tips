package com.tips.registration.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author herasimau on 08.10.2016.
 */

public class JsonResponse {

    public static final Map<String, Boolean> successTrue;
    public static final Map<String, Boolean> successFalse;

    static {
        successTrue = new HashMap<>();
        successTrue.put("success",true);
        successFalse = new HashMap<>();
        successFalse.put("success",false);
    }
}

