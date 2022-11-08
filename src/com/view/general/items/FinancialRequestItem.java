package com.view.general.items;

import com.domain.FinancialRequest;

public class FinancialRequestItem extends RequestItem {

    public FinancialRequestItem(FinancialRequest financialRequest) {
        super(financialRequest);
    }

    @Override
    public String toString() {
        //return ((FinancialRequest)getRequest()).getTask().getEvent().getEventRequest().getRecordNumber().toString();
        return ((FinancialRequest)getRequest()).getReason();
    }
}
