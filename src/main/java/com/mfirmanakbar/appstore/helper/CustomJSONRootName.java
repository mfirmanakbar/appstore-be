package com.mfirmanakbar.appstore.helper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomJSONRootName {
    String singular();

    String plural();
}
