package com.waylon.serverbookstore.services;

import com.waylon.serverbookstore.moudels.Notice;

import java.util.List;

/**
 * @author Waylon
 */
public interface INoticeService {
    List<Notice> selectAllNotice();
}
