package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.dto.pdf.CountryReq;
import com.demo.bookmyshow.service.SendPDFAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SendPdfController
{

    @Autowired
    private SendPDFAttachmentService sendPDFAttachmentService;

    @PostMapping("/getPdf")
    public ResponseEntity<Resource> getPdf(@RequestBody CountryReq req) throws IOException {
        return new ResponseEntity(sendPDFAttachmentService.getPDF(req), HttpStatus.OK);
    }

}
