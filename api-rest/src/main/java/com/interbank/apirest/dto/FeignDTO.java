package com.interbank.apirest.dto;

import java.util.HashMap;
import java.util.List;

public class FeignDTO {
	private String result;
	private String provider;
	private String documentation;
	private Integer time_last_update_unix;
	private String time_last_update_utc;
	private Integer time_next_update_unix;
	private String time_next_update_utc;
	private Integer time_eol_unix;
	private String base_code;
	
	private HashMap rates;

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public Integer getTime_last_update_unix() {
		return time_last_update_unix;
	}

	public void setTime_last_update_unix(Integer time_last_update_unix) {
		this.time_last_update_unix = time_last_update_unix;
	}

	public String getTime_last_update_utc() {
		return time_last_update_utc;
	}

	public void setTime_last_update_utc(String time_last_update_utc) {
		this.time_last_update_utc = time_last_update_utc;
	}

	public Integer getTime_next_update_unix() {
		return time_next_update_unix;
	}

	public void setTime_next_update_unix(Integer time_next_update_unix) {
		this.time_next_update_unix = time_next_update_unix;
	}

	public String getTime_next_update_utc() {
		return time_next_update_utc;
	}

	public void setTime_next_update_utc(String time_next_update_utc) {
		this.time_next_update_utc = time_next_update_utc;
	}

	public Integer getTime_eol_unix() {
		return time_eol_unix;
	}

	public void setTime_eol_unix(Integer time_eol_unix) {
		this.time_eol_unix = time_eol_unix;
	}

	public String getBase_code() {
		return base_code;
	}

	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

	public HashMap getRates() {
		return rates;
	}

	public void setRates(HashMap rates) {
		this.rates = rates;
	}
	
	
	
	
}
