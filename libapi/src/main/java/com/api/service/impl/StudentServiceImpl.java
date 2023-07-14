package com.api.service.impl;

import com.api.common.StudentStatus;
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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

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

//    private void mappingDtcRecommendation(String recommend, Integer dtcId){
//        if (StringUtils.isBlank(recommend)){
//            return;
//        }else if (!recommend.contains("\n")){
//            Optional<Recommendation> recommendationOpt = recommendationRepository.findByDescription(recommend);
//            if (recommendationOpt.isPresent()){
//                DtcRecommendation dtcRecommendation = new DtcRecommendation();
//                dtcRecommendation.setDtcData(dtcRepository.findById(dtcId).get());
//                dtcRecommendation.setRecommendation(recommendationOpt.get());
//                dtcRecommendationRepository.save(dtcRecommendation);
//                dtcRecommendationRepository.save(dtcRecommendation);
//            }
//        } else{
//            String[] split = recommend.split("\n");
//            System.out.println(split[0].trim());
//            System.out.println(split[1].trim());
//            System.out.println("**************");
//            for (int i = 0; i<split.length;i++){
//                Optional<Recommendation> recommendationOpt = recommendationRepository.findByDescription(split[i].trim());
//                if (recommendationOpt.isPresent()){
//                    DtcRecommendation dtcRecommendation = new DtcRecommendation();
//                    dtcRecommendation.setDtcData(dtcRepository.findById(dtcId).get());
//                    dtcRecommendation.setRecommendation(recommendationOpt.get());
//                    dtcRecommendationRepository.save(dtcRecommendation);
//                    dtcRecommendationRepository.save(dtcRecommendation);
//                }
//            }
//        }
//    }
//
//    private List<DTCDataDTO> mapEntityToDTO(List<DtcData> listEntity){
//        ModelMapper modelMapper = new ModelMapper();
//        return listEntity.stream().map(entity -> modelMapper.map(entity, DTCDataDTO.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public PagingDTCDataDTO getListDtcData (Integer pageNumber, Integer pageSize){
//        Pageable paging = PageRequest.of(pageNumber - 1, pageSize);
//        Page page = dtcRepository.findAll(paging);
//        PagingDTCDataDTO pagingDTCDataDTO = new PagingDTCDataDTO();
//        pagingDTCDataDTO.setPageSize(page.getSize());
//        pagingDTCDataDTO.setTotalPage(page.getTotalPages());
//        pagingDTCDataDTO.setListDtcDataDto(mapEntityToDTO(page.toList()));
//        return pagingDTCDataDTO;
//    }
}

