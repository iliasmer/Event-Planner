package com.memorydao;

import com.dao.RecruitmentRequestDAO;
import com.domain.AcceptRejectState;
import com.domain.RecruitmentRequest;

import java.util.ArrayList;

public class RecruitmentRequestDAOMemory implements RecruitmentRequestDAO {

    private static ArrayList<RecruitmentRequest> entities = new ArrayList<>();

    public void save(RecruitmentRequest recruitmentRequest){
        entities.add(recruitmentRequest);
    }

    public ArrayList<RecruitmentRequest> getRecruitmentRequests(AcceptRejectState state) {
        ArrayList<RecruitmentRequest> result = new ArrayList<>();

        for (RecruitmentRequest recruitmentRequest: entities) {
            if (recruitmentRequest.getState() == state){
                result.add(recruitmentRequest);
            }
        }
        return result;
    }

}
