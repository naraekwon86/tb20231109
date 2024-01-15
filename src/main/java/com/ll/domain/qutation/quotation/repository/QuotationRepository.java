package com.ll.domain.qutation.quotation.repository;

import com.ll.domain.qutation.quotation.entity.Quotation;

import java.util.List;
import java.util.Optional;

public class QuotationRepository {
    private final List<Quotation> quotations;
    private long lastQuotationId;
    public List<Quotation> findAll(){
        return quotations;
    }
    public void delete(Quotation quotation){
        quotations.remove(quotation);
    }
    public Optional<Quotation> findById(long id){
        return quotations
                .stream()
                .filter(quotation -> quotation.getId() == id)
                .findFirst();
    }
    public void save(Quotation quotation){
        if (quotation.getId() == null){
            quotation.setId(++lastQuotationId);
            quotations.add(quotation);
        }
    }
}
