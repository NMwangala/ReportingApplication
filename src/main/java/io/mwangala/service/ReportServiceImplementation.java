package io.mwangala.service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import io.mwangala.entity.Report;
import io.mwangala.entity.ReportRepository;
import io.mwangala.utils.Utils;

@Service 
@Transactional
public class ReportServiceImplementation implements ReportService{
	
	
	@Autowired
	private ReportRepository reportRepository;

	public ReportServiceImplementation() {
		
	}
	@Override
	public List<Report> findAll() {
		
		return (List<Report>) reportRepository.findAll();
	}

	@Override
	public boolean saveDataFromFileUpload(MultipartFile file) {
		boolean isSaved = false;
		
		String fileExtension  = FilenameUtils.getExtension(file.getOriginalFilename());
		
		if(fileExtension.equalsIgnoreCase("csv")) {
			isSaved = readDataFromCSVFile(file);
			
		}else if(fileExtension.equalsIgnoreCase("xls") || fileExtension.equalsIgnoreCase("xlsx")) {
			isSaved = readDataFromExcelFile(file);
		}else {
			isSaved=false;
			System.out.println("Invalid file format.");
		}
		
		return isSaved;
	}

	private boolean readDataFromExcelFile(MultipartFile file) {
	Workbook workBook = getWorkBook(file);
	Sheet sheet = workBook.getSheetAt(0);
	Iterator<Row> rows = sheet.iterator();
	rows.next();
	while(rows.hasNext()) {
		Row row = rows.next();
		Report report = new Report();
//		if(row.getCell(0).getCellType()==Cell.CELL_TYPE_STRING) {
//			
//		}
	}
		return false;
	}

	private Workbook getWorkBook(MultipartFile file) {
		Workbook workbook = null;
		try {
		
		String fileExtension  = FilenameUtils.getExtension(file.getOriginalFilename());
		
		if(fileExtension.equalsIgnoreCase("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		}else if(fileExtension.equalsIgnoreCase("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}
	
		}catch(Exception ex) {
			
		}
		return workbook;
	}

	private boolean readDataFromCSVFile(MultipartFile file) {
		try {
			InputStreamReader reader = new InputStreamReader(file.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows = csvReader.readAll();  
			
			
			for(String[] row:rows) {
				reportRepository.save(new Report(row[0], row[1], row[2], row[3], row[4], 
			   Utils.parseDate(row[5]), row[6], Utils.parseDate(row[7]), Utils.StringToInt(row[8]), 
			   Utils.StringToDouble(row[9]), Utils.StringToDouble(row[10]), Utils.StringToDouble(row[11]), 
			   Utils.StringToDouble(row[12]), Utils.StringToDouble(row[13])));
			}
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Override
	public List<Object[]> getProfitableItems(String start, String end) {
		
		return reportRepository.getProfitableItems(start,end);
	}
	@Override
	public Double getTotalProfit(String start, String end) {
		// TODO Auto-generated method stub
		return reportRepository.getTotalProfit(start, end);
	}
	
	
	
}