package com.covid19.model;

public class Covid19DataVO {
	private String provinceState;
	private String countryRegion;
	private Double lat;
	private Double lng;
	private Integer latestConformedCases;
	
	public String getProvinceState() {
		return provinceState;
	}
	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Integer getLatestConformedCases() {
		return latestConformedCases;
	}
	public void setLatestConformedCases(Integer latestConformedCases) {
		this.latestConformedCases = latestConformedCases;
	}
	@Override
	public String toString() {
		return "Covid19DataVO [provinceState=" + provinceState + ", countryRegion=" + countryRegion + ", lat=" + lat
				+ ", lng=" + lng + ", latestConformedCases=" + latestConformedCases + "]";
	}
	
}
