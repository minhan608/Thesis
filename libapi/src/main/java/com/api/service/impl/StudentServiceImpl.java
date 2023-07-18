package com.api.service.impl;

import com.api.common.StudentStatus;
import com.api.convert.StudentConverter;
import com.api.dto.student.PagingStudentDto;
import com.api.dto.student.StudentDto;
import com.api.dto.student.StudentRecordDto;
import com.api.entity.StudentRecord;
import com.api.exception.GlobalException;
import com.api.repository.StudentRepository;
import com.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private boolean isValidExcelFile (MultipartFile file){
        return StringUtils.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    @Override
    public void saveStudentRecord (MultipartFile file, Integer semester, Integer year) throws Exception {
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
                StudentRecord studentRecord = new StudentRecord();
                studentRecord.setSemester(semester);
                studentRecord.setYear(year);
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 1:
                            studentRecord.setStudentName(cell.getStringCellValue());
                            break;
                        case 2:
                            studentRecord.setStudentId(cell.getStringCellValue());
                            break;
                        case 3:
                            studentRecord.setStatus(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                studentRepository.save(studentRecord);
            }
        } catch (Exception e) {
            throw new GlobalException("fail to store excel data: " + e.getMessage(),"Fail ");
        }
    }

    @Override
    public List<StudentDto> getListStudent() {
        List<StudentRecord> listStudent = studentRepository.findAll();
        List<StudentDto> listDto = listStudent.stream()
                .map(StudentConverter::convertRecordToStudentDto)
                .collect(Collectors.toList());

        return listDto;
    }

    private List<StudentDto> getListStudentByYearSemester(int semester , int year) {
        List<StudentRecord> listStudent = studentRepository.findAllBySemesterAndYear(semester,year);
        List<StudentDto> listDto = listStudent.stream()
                .map(StudentConverter::convertRecordToStudentDto)
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public StudentRecordDto getRecord(int semester, int year){
        StudentRecordDto studentRecordDto = new StudentRecordDto();
        List<StudentDto> studentDtos = getListStudentByYearSemester(semester, year);
        int noStudy=0;
        int noReserved=0;
        int noDrop=0;
        for (StudentDto student : studentDtos) {
            String status = student.getStatus();

            if (status.equals("Studying")) {
                noStudy++;
            } else if (status.equals("Reserved")) {
                noReserved++;
            } else if (status.equals("Dropped")) {
                noDrop++;
            }
            studentRecordDto.setNoStudy(noStudy);
            studentRecordDto.setNoReserved(noReserved);
            studentRecordDto.setNoDrop(noDrop);
        }
        return studentRecordDto;
    }

//    @Override
//    public PagingStudentDto getPaging (Integer pageNumber, Integer pageSize){
//        Pageable paging = PageRequest.of(pageNumber - 1, pageSize);
//        Page page = studentRepository.findAll(paging);
//        PagingStudentDto pagingStudentDto = new PagingStudentDto();
//        pagingStudentDto.setSize(page.getSize());
//        pagingStudentDto.setPage(page.getTotalPages());
//        pagingStudentDto.setListStudent(mapEntityToDTO(page.toList()));
//        return pagingDTCDataDTO;
//    }
}

