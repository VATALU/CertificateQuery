package org.vatalu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.vatalu.map.WorkMapper;
import org.vatalu.model.entity.Work;
import org.vatalu.model.response.CommonResponse;
import org.vatalu.util.PdfUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadServiceImpl {
    @Autowired
    private WorkMapper workMapper;

    public CommonResponse getCertificatePdf(String filepath, String pdfpath, String fontpath, String number) {
        Work work = workMapper.findByNumber(number);
        PdfUtil pdfHelper = new PdfUtil();
        try {
            pdfHelper.createPdf(filepath, pdfpath, fontpath, work);
            return new CommonResponse(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonResponse(true);
    }
}
