package io.mwangala.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.mwangala.entity.Report;

public interface ReportService {

	List<Report> findAll();

	boolean saveDataFromFileUpload(MultipartFile file);

	List<Object[]> getProfitableItems(String start, String end);

	Double getTotalProfit(String start, String end);

}
