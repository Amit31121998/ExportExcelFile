package com.amit;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService reportservice;

	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=courses.xls";
		response.setHeader(headerKey, headerValue);

		reportservice.generateExcel(response);
	}
}
