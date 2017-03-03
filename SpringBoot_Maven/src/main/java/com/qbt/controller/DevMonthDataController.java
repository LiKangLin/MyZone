package com.qbt.controller;

import com.qbt.repository.DevMonthDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ALKL on 2017/1/3.
 */
@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DevMonthDataController {
   @Autowired
    private DevMonthDataRepository devMonthDataRepository;

    public int din=2;

    public void setDevMonthDataRepository(DevMonthDataRepository devMonthDataRepository) {
        this.devMonthDataRepository = devMonthDataRepository;
    }
    @RequestMapping(value="/devMonthDatafind/{din}", method = RequestMethod.GET)
    @ResponseBody
    public void UserJpa(@PathVariable("din") int did){
         devMonthDataRepository.UserJpa(din);

    }

    /*public DevMonthData findByName(@PathVariable("userNo") String userNo) {

        return devMonthDataRepository.findByUserNo(userNo);
    }*/

}
