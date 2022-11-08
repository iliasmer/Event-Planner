package com.memorydao;

import com.dao.FinancialRequestDAO;
import com.domain.AcceptRejectState;
import com.domain.BinaryState;
import com.domain.EventRequest;
import com.domain.FinancialRequest;

import java.util.ArrayList;

public class FinancialRequestDAOMemory implements FinancialRequestDAO {

    protected static ArrayList<FinancialRequest> entities = new ArrayList<FinancialRequest>();

    @Override
    public void save(FinancialRequest financialRequest) {
        entities.add(financialRequest);
    }

    @Override
    public ArrayList<FinancialRequest> getFinancialRequest(AcceptRejectState state) {
        ArrayList<FinancialRequest> result = new ArrayList<>();
        for(FinancialRequest financialRequest : entities){
            if (financialRequest.getState() == state) {
                result.add(financialRequest);
            }
        }
        return result;
    }
}


