package com.ll.domain.qutation.export.service;

import com.ll.standard.util.Ut;

public class ExportService {
    public void export(){
        Ut.file.save("data/data.json", "[]");
    }
}
