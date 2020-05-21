/**
 * Error message object wrapper
 */

package com.mfirmanakbar.appstore.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse {

    private String message;

    public CommonResponse(String message) {
        this.message = message;
    }

}
