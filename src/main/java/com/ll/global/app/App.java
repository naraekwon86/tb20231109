package com.ll.global.app;

import com.ll.domain.qutation.export.controller.ExportController;
import com.ll.domain.qutation.quotation.controller.QuotationController;
import com.ll.global.rq.Rq;

import java.util.Scanner;

public class App {
        private final Scanner scanner;

    public App(final Scanner scanner){
        this.scanner = scanner;
    }
    public void run(){
        System.out.println("== 명언 앱 ==");
        final QuotationController quotationController = new QuotationController(scanner);
        final ExportController exportController = new ExportController(scanner);

        while (true) {
            System.out.print("명령) ");

            final String cmd = scanner.nextLine().trim();

            final Rq rq = new Rq(cmd);

            switch (rq.getAction()){
                case "삭제", "수정", "등록", "목록" -> quotationController.dispatch(rq);
                case "빌드" -> exportController.dispatch(rq);
                case "종료" -> {
                    return;
                }
            }
        }
    }
}


