package com.view.general.items;

import com.domain.RecruitmentRequest;

public class RecruitmentRequestItem extends RequestItem {

    public RecruitmentRequestItem(RecruitmentRequest recruitmentRequest) {
        super(recruitmentRequest);
    }

    @Override
    public String toString() {
        return ((RecruitmentRequest) getRequest()).getJobTitle();
    }
}

