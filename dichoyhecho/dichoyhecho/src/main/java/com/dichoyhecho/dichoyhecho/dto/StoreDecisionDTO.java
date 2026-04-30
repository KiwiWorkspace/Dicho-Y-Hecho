package com.dichoyhecho.dichoyhecho.dto;

import com.dichoyhecho.dichoyhecho.enums.StoreStatus;
import jakarta.validation.constraints.NotNull;

public class StoreDecisionDTO {

    // the admin can only send approved or rejected, never pending
    @NotNull(message = "you must indicate a decision: approved or rejected")
    private StoreStatus decision;

    // required only if the decision is rejected (validated in service)
    private String rejectionReason;

    public StoreStatus getDecision() {
        return decision;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setDecision(StoreStatus decision) {
        this.decision = decision;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}