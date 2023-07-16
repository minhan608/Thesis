package com.api.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRecordDto {

    private int noStudy;

    private int noReserved;

    private int noDrop;
}
