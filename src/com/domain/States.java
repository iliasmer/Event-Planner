package com.domain;

public enum States {
    SCS_INIT,
    SCS_REJECTED,
    FM, // SCS_APPROVED
    ADMIN,
    ADMIN_REJECTED,
    SCS_END,
    FM_REJECTED, // ADMIN_APPROVED
    SCS_BACK
}
