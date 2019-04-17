package com.a0519.willson.test_cafe2.Common;

import com.a0519.willson.test_cafe2.Model.User;

/**
 * Created by Willson Leow on 23/11/2017.
 */

public class Common {
    public static User currentUser;

    public static String convertCodeToStatus(String status) {
        if(status.equals("0"))
            return "Placed";

        else if(status.equals("1"))
            return "On my way";

        else
            return "Shipped";



    }
}
