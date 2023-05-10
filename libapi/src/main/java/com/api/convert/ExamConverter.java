package com.api.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ExamConverter {

    private static final ModelMapper viewExam;

    private static final ModelMapper saveExamMapper;

    private static final ObjectMapper patchObjectMapper;

    private ExamConverter() {
    }

    static {
        viewExam = getViewDataMapper();

        saveExamMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

//    public static ViewDtcDataDTO convertDTCDataEntityToViewDTO(DtcData dtcDataEntity) {
//        return viewDataMapper.map(dtcDataEntity, ViewDtcDataDTO.class);
//    }
//
//    public static void mapSaveDtcDataDTOToDtcData(SaveDtcDataDTO saveDtcDataDTO, DtcData dtcData) {
//        saveDataMapper.map(saveDtcDataDTO, dtcData);
//    }

    private static ModelMapper getViewDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getSaveDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getDefaultModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
