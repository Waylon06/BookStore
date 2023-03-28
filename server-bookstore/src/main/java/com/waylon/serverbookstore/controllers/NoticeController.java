package com.waylon.serverbookstore.controllers;

import com.waylon.serverbookstore.moudels.Notice;
import com.waylon.serverbookstore.services.INoticeService;
import com.waylon.serverbookstore.utils.Code;
import com.waylon.serverbookstore.utils.Respond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Waylon
 */
@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping("/list")
    public Respond noticeList() {
        List<Notice> notices = noticeService.selectAllNotice();
        return new Respond(Code.SUCCESS, "获取成功", notices);
    }
}
