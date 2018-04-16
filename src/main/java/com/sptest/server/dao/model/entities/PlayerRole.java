package com.sptest.server.dao.model.entities;

import static com.sptest.server.utils.DBConstants.ROLE_ADMIN;
import static com.sptest.server.utils.DBConstants.ROLE_TESTER;
import static com.sptest.server.utils.DBConstants.ROLE_USER;
import static com.sptest.server.utils.DBConstants.ROLE_VIP_USER;

public enum PlayerRole {
    USER(ROLE_USER),
    ADMIN(ROLE_ADMIN),
    TESTER(ROLE_TESTER),
    VIP_USER(ROLE_VIP_USER);
    private String code;

    PlayerRole(String code) {
        this.code = code;
    }

    public String getStatus() {
        return this.code;
    }

}

