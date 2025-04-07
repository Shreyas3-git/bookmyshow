package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.pdf.CountryReq;
import com.demo.bookmyshow.dto.pdf.PDFConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendPDFAttachmentService
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String FOLDER_LOCATION = "templates/";

    public Map<String,String> getPDF1(CountryReq country) throws IOException {
        String documentName = "";
        Map<String,String> map = new HashMap<>();
        if(country.getIsoCode().equalsIgnoreCase("DE") || country.getIsoCode().equalsIgnoreCase("AT")
                || country.getIsoCode().equalsIgnoreCase("CH")) {
            documentName = PDFConstants.AWS_PAYMENT_BILL;
        }
        else if(country.getIsoCode().equals("IT")) {
            documentName = PDFConstants.LOAN_INTREST_CERTIFICATE;
        }
        if(!documentName.isEmpty()) {
            map.put("documentName",documentName);
            log.info("documentName in getPDF will be: {}",documentName);
            InputStream templateIn = new ClassPathResource(FOLDER_LOCATION + documentName).getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int c = -1;
            while((c = templateIn.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer,0,c);
            }

            map.put("base64", Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()));
        }
        return map;
    }


    public Resource getPDF(CountryReq country) throws IOException {
        // Step 1: Call getPDF1 to get the map
        Map<String, String> map = getPDF1(country);

        // Step 2: Get documentName and check if it's not empty or blank
        if (map.containsKey("documentName")) {
            String documentName = map.get("documentName");
            String base64 = map.get("base64");
            if (base64 == null || base64.isEmpty()) {
                throw new IOException("Base64 content is empty for document: " + documentName);
            }
            byte[] pdfBytes = Base64.getDecoder().decode(base64);

            return new ByteArrayResource(pdfBytes);
        }
        throw new IOException("Document name is empty or blank for the given country");

    }

}
