package com.dao;

import com.domain.AcceptRejectState;
import com.domain.RecruitmentRequest;

import java.util.ArrayList;

public interface RecruitmentRequestDAO {
    void save(RecruitmentRequest recruitmentRequest);

    ArrayList<RecruitmentRequest> getRecruitmentRequests(AcceptRejectState state);
}
