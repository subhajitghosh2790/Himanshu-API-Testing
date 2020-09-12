package utility;

import java.util.Date;

public class OtherUtilities {

    final String CLIENT_REQUEST_ID() {

        return (int) (Math.floor((Math.random() * 10000000) + 1)) + "";
    }

    final String TIMESTAMP() {
        return new Date().getTime() + "";
    }
}