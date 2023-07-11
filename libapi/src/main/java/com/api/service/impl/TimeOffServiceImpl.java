package com.api.service.impl;

import com.api.convert.TaskConverter;
import com.api.convert.TimeOffConverter;
import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.dto.timeoff.TimeOffDto;
import com.api.dto.timeoff.ViewTimeOffDto;
import com.api.entity.Task;
import com.api.entity.TimeOff;
import com.api.repository.TaskRepository;
import com.api.repository.TimeOffRepository;
import com.api.service.TimeOffService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeOffServiceImpl implements TimeOffService {

    private final TimeOffRepository timeOffRepository;

    @Override
    public ViewTimeOffDto createTime(TimeOffDto timeOffDto) {
        TimeOff newTimeOff = TimeOff.builder().build();
        TimeOffConverter.mapTimeOffDtoToTimeOff(timeOffDto , newTimeOff);
        timeOffRepository.save(newTimeOff);
        return TimeOffConverter.convertTimeOffToTimeOffDTO(newTimeOff);
    }

    @Override
    public ViewTimeOffDto updateTime(Integer id, TimeOffDto timeOffDto) throws NotFoundException {

        TimeOff timeOff = timeOffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Time Off of lecturer not found"));

        TimeOffConverter.mapTimeOffDtoToTimeOff(timeOffDto, timeOff);
        timeOff.setDateOff(LocalDate.now());
        timeOff = timeOffRepository.save(timeOff);
        return TimeOffConverter.convertTimeOffToTimeOffDTO(timeOff);
    }

    @Override
    public void deleteTime(Integer id) throws NotFoundException {
        if (!timeOffRepository.existsById(id)) {
            throw new NotFoundException("Task not found");
        }
        timeOffRepository.deleteById(id);
    }
}
