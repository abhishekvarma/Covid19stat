package com.covid19.services;

import java.io.StringReader;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid19.DataAccess.Covid19DAO;
import com.covid19.model.Covid19DataVO;

@Service
public class Covid19Service {
	
	ArrayList<Covid19DataVO> mainData = new ArrayList<Covid19DataVO>();
	
	public ArrayList<Covid19DataVO> getMainData() {
		return mainData;
	}

	public void setMainData(ArrayList<Covid19DataVO> mainData) {
		this.mainData = mainData;
	}

	@PostConstruct
	@Scheduled(cron = "* 1 * * * *")
	public void fetchData() {
		try {
			System.out.println(new Date());
			ArrayList<Covid19DataVO> data = new ArrayList<Covid19DataVO>();
			Covid19DAO dao = new Covid19DAO();
			HttpResponse<String> httpResponse = dao.fetchData();			
			//System.out.println(httpResponse.body());
			StringReader csvReader = new StringReader(httpResponse.body());
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
			for(CSVRecord record: records) {
				Covid19DataVO vo = new Covid19DataVO();
				vo.setProvinceState(record.get("Province/State"));
				vo.setCountryRegion(record.get("Country/Region"));
				vo.setLat(Double.parseDouble(record.get("Lat")));
				vo.setLng(Double.parseDouble(record.get("Long")));
				vo.setLatestConformedCases(Integer.parseInt(     record.get(   record.size() - 1  )     ));
				//System.out.println(vo);
				data.add(vo);
			}
			this.mainData = data;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Integer getTotalConformed(ArrayList<Covid19DataVO> mainData) {
		Integer total = mainData.stream().mapToInt(stat -> stat.getLatestConformedCases()).sum();
		return total;
	}
}
