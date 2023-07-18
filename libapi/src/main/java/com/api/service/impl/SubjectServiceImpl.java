package com.api.service.impl;

import com.api.dto.SubjectDto;
import com.api.entity.Subject;
import com.api.exception.GlobalException;
import com.api.repository.SubjectRepository;
import com.api.service.SubjectService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    @Override
    public void uploadExcel(MultipartFile file,String name, String teacher, int semester, int year) throws Exception {
        try{
            XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = wb.getSheet("Sheet1");
            int rowIndex = 0;

            for (Row row : sheet){
                if (rowIndex == 0){
                    rowIndex++;
                    continue;
                }

                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Subject subject = new Subject();
                int noPassed = 0;
                int noFailed = 0;
                int noProhibited = 0;
                int noAbsent = 0;
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 4:
                            Double score = cell.getNumericCellValue();
                            if (score >=50 ){
                                noPassed++;
                            }else if (score <50){
                                noFailed++;
                            }else{
                                noFailed++;
                            }
                            break;
                        case 5:
                            String value = cell.getStringCellValue();
                            if (StringUtils.isBlank(value)){
                                break;
                            }else if (value.equalsIgnoreCase("Prohibited")){
                                noProhibited++;
                                noFailed--;
                            }else if (value.equalsIgnoreCase("Absent")){
                                noAbsent++;
                                noFailed--;
                            }
                        default:
                            break;
                    }
                    cellIndex++;
                }
                subject.setName(name);
                subject.setTeacher(teacher);
                subject.setSemester(semester);
                subject.setYear(year);
                subject.setNoPassed(noPassed);
                subject.setNoFailed(noFailed);
                subject.setNoProhibited(noProhibited);
                subject.setNoAbsent(noAbsent);
                subjectRepository.save(subject);
            }
        } catch (Exception e) {
            throw new GlobalException("fail to store excel data: " + e.getMessage(),"Fail ");
        }
    }

    @Override
    public Subject getResultFromDb(){
        List<Subject> subjects = subjectRepository.findAll();

        int totalPassed = 0;
        int totalFailed = 0;
        int totalProhibited = 0;
        int totalAbsent = 0;
        int semester = 0;
        int year = 0;
        String name = StringUtils.EMPTY;
        String teacher = StringUtils.EMPTY;

        for (Subject subject : subjects) {
            totalPassed += subject.getNoPassed();
            totalFailed += subject.getNoFailed();
            totalProhibited += subject.getNoProhibited();
            totalAbsent += subject.getNoAbsent();
            name = subject.getName();
            teacher = subject.getTeacher();
            year = subject.getYear();
            semester = subject.getSemester();
        }

        Subject result = new Subject();
        result.setNoPassed(totalPassed);
        result.setNoFailed(totalFailed);
        result.setNoProhibited(totalProhibited);
        result.setNoAbsent(totalAbsent);
        result.setTeacher(teacher);
        result.setName(name);
        result.setYear(year);
        result.setSemester(semester);
        return result;
    }

    @Override
    public SubjectDto getResult(String name, String teacher, int semester, int year) {
        List<Subject> subjects = subjectRepository.findAllByNameAndTeacherAndSemesterAndYear(name, teacher, semester, year);

        int totalPassed = 0;
        int totalFailed = 0;
        int totalProhibited = 0;
        int totalAbsent = 0;

        for (Subject subject : subjects) {
            totalPassed += subject.getNoPassed();
            totalFailed += subject.getNoFailed();
            totalProhibited += subject.getNoProhibited();
            totalAbsent += subject.getNoAbsent();
        }

        SubjectDto result = new SubjectDto();
        result.setNoPassed(totalPassed);
        result.setNoFailed(totalFailed);
        result.setNoProhibited(totalProhibited);
        result.setNoAbsent(totalAbsent);

        return result;
    }
}
