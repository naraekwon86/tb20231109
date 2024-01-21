package com.ll.domain.qutation.export.service;

import com.ll.domain.qutation.quotation.Service.QuotationService;
import com.ll.domain.qutation.quotation.entity.Quotation;
import com.ll.standard.util.Ut;

import java.util.List;

public class ExportService {
    final QuotationService quotationService;

    public ExportService(){
        quotationService = new QuotationService();
    }

    public void export(){
       final List<Quotation> quotations = quotationService.findAll();
        Ut.file.save("data/data.json", quotations);
    }
}
