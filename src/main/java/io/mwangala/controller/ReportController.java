package io.mwangala.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.mwangala.entity.ProfitableItemType;
import io.mwangala.entity.Report;
import io.mwangala.utils.Utils;
import io.mwangala.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("report", new Report());
		List<Report> reports = reportService.findAll();
		 model.addAttribute("reports", reports);
		return "view/reports";
	}

	@PostMapping(value = "/fileUpload")
	public String uploadFile(@ModelAttribute Report report, RedirectAttributes redirectAttributes) {
		boolean isSaved = reportService.saveDataFromFileUpload(report.getFile());
		if (isSaved) {
			redirectAttributes.addFlashAttribute("successMessage", "File uploaded Successfully.");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "File uploaded failed.Please try again!");
		}
		return "redirect:/";

	}

	@PostMapping(value = "/report")
	public String getProfitableItems(RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		System.out.println("fromDate " +fromDate +" toDate " +toDate);
		List<ProfitableItemType> profitableItemTypeList = new ArrayList<>();
		List<Object[]> listObjects = reportService.getProfitableItems(fromDate, toDate);
		
		for (Object[] obj : listObjects) {
//			System.out.println((String) obj[0]);
			Double totalItemProfit = (Double)obj[1];
		//	System.out.println(bd.toString());
			ProfitableItemType profitableItems = new ProfitableItemType();
			profitableItems.setItemType((String) obj[0]);
			
			profitableItems.setTotalItemsSold(Utils.doubleToString(totalItemProfit));
			profitableItemTypeList.add(profitableItems);
			
		}
		redirectAttributes.addFlashAttribute("profitableItems",profitableItemTypeList);	
		
		redirectAttributes.addFlashAttribute("totalProfit",Utils.doubleToString(reportService.getTotalProfit(fromDate, toDate)));

		return "redirect:/";
	}

	

	
}
