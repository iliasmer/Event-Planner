package com.dao;

import com.domain.AcceptRejectState;
import com.domain.FinancialRequest;
import com.domain.BinaryState;

import java.util.ArrayList;

public interface FinancialRequestDAO {

    void save(FinancialRequest financialRequest);

    ArrayList<FinancialRequest> getFinancialRequest(AcceptRejectState state);
}
