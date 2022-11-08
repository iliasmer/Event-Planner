package com.memorydao;

import com.dao.*;

public class MemoryInitializer extends Initializer {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMemory();
    }

    @Override
    public EventRequestDAO getEventRequestDAO() {
        return new EventRequestDAOMemory();
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOMemory();
    }

    @Override
    public RecruitmentRequestDAO getRecruitmentRequestDAO() {
        return new RecruitmentRequestDAOMemory();
    }
    @Override
    public FinancialRequestDAO getFinancialRequestDAO() {
        return new FinancialRequestDAOMemory();
    }
}
