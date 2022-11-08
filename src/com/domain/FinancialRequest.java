package com.domain;

public class FinancialRequest extends Request{
    Integer amount;
    String reason;
    //Task task;
    AcceptRejectState state;

    public FinancialRequest(Integer amount, String reason) {
        this.amount = amount;
        this.reason = reason;
        //this.task = task;
        this.state = AcceptRejectState.NEW;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

/*    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }*/

    public AcceptRejectState getState() {
        return state;
    }

    public void setState(AcceptRejectState acceptRejectState) {
        this.state = acceptRejectState;
    }
}
