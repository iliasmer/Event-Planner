package com.view.general.items;

import com.domain.Request;

public abstract class RequestItem {
    Request request;
    public RequestItem(Request request){
        this.request = request;
    };

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
