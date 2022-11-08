package com.view.general.event_requests;

import com.domain.*;
import com.view.general.items.EventRequestItem;
import com.view.general.items.FinancialRequestItem;
import com.view.general.items.RecruitmentRequestItem;
import com.view.general.items.RequestItem;

import javax.swing.*;
import java.util.ArrayList;

public class ListModels<T extends RequestItem> {
    public DefaultListModel<T> createList(ArrayList<? extends Request> requests) {
        DefaultListModel<T> listModel = new DefaultListModel<>();

        for (Request request: requests){
            if (request instanceof EventRequest){
                EventRequestItem item = new EventRequestItem((EventRequest) request);
                listModel.addElement((T) item);
            } else if (request instanceof FinancialRequest) {
                FinancialRequestItem item = new FinancialRequestItem((FinancialRequest) request);
                listModel.addElement((T) item);
            } else if (request instanceof RecruitmentRequest) {
                RecruitmentRequestItem item = new RecruitmentRequestItem((RecruitmentRequest) request);
                listModel.addElement((T) item);
            }
        }
        return listModel;
    }

}


