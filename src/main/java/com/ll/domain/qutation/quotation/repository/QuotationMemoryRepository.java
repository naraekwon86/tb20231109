package com.ll.domain.qutation.quotation.repository;

import com.ll.domain.qutation.quotation.entity.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuotationMemoryRepository implements QuotationRepository{
    private final List<Quotation> quotations;
    private long lastId;

    public QuotationMemoryRepository(){
        quotations = new ArrayList<>();
        lastId = 0;
    }
    @Override
    public List<Quotation> findAll(){
        return quotations;
    }
    @Override
    public boolean delete(final Quotation quotation){

        return quotations.remove(quotation);
    }
    @Override
    public Optional<Quotation> findById(final long id){
        return quotations
                .stream()
                .filter(quotation -> quotation.getId() == id)
                .findFirst();
    }
    @Override
    public void save(final Quotation quotation){
        if (quotation.getId() == null){
            quotation.setId(++lastId);
            quotations.add(quotation);
        }
    }

}
