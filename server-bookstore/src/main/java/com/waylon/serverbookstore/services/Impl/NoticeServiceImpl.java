package com.waylon.serverbookstore.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waylon.serverbookstore.mapper.NoticeMapper;
import com.waylon.serverbookstore.moudels.Notice;
import com.waylon.serverbookstore.services.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waylon
 */
@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectAllNotice() {
        List<Notice> notices = noticeMapper.selectList(null);
        return notices;
    }
}
