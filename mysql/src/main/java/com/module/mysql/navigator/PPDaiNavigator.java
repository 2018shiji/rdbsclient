package com.module.mysql.navigator;

import com.module.mysql.ppDai.repository.ILoanPlanRepository;
import com.module.mysql.ppDai.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PPDaiNavigator {
    @Autowired
    ILoanRepository loanRepo;
    @Autowired
    ILoanPlanRepository loanPlanRepo;

    @ResponseBody
    @RequestMapping("migratePPDaiSingle")
    public String migratePPDaiSingle(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("migratePPDaiBatch")
    public String migratePPDaiBatch(){
        return "success";
    }
}
