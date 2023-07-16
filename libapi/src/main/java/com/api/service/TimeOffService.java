package com.api.service;

import com.api.dto.timeoff.TimeOffDto;
import com.api.dto.timeoff.ViewTimeOffDto;
import com.api.entity.TimeOff;
import javassist.NotFoundException;

import java.util.List;

public interface TimeOffService {

    ViewTimeOffDto createTime(TimeOffDto timeOffDto);

    ViewTimeOffDto updateTime(Integer id, TimeOffDto timeOffDto) throws NotFoundException;

    void deleteTime(Integer id) throws NotFoundException;

    List<TimeOff> getList();
}
