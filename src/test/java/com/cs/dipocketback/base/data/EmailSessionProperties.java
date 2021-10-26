package com.cs.dipocketback.base.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EmailSessionProperties {

    //                jndiName              X-Mailer
    DIPOCKET_SMTP    ("mail/DiPocketMail",  "DiPocket Mailer"),
    UPANDGO_SMTP     ("mail/UpAndGoMail",   "UpAndGo Mailer"),
    SODEXO_SMTP     ("mail/SodexoMail",   "DiPocket Mailer");

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSessionProperties.class);

    private String jndiName;
    private String xMailerHeader;
    
    EmailSessionProperties(String jndiName, String xMailerHeader) {
        this.jndiName = jndiName;
        this.xMailerHeader = xMailerHeader;
    }

    public String getJndiName() {
        return "java:/comp/env/" + jndiName;
    }

    public String getJndiNameForTomcat() {
        return jndiName;
    }

    public String getXMailerHeader() {
        return xMailerHeader;
    }

}
