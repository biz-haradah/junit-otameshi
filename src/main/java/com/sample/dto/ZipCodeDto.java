package com.sample.dto;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeDto {
	/** �X�e�[�^�X */
	int status;
	
	/** ���b�Z�[�W */
	String message;
	
	/** �X�֔ԍ���񃊃X�g */
	List<ZipCodeDataDto> results = new ArrayList<ZipCodeDataDto>();

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ZipCodeDataDto> getResults() {
		return results;
	}

	public void setResults(List<ZipCodeDataDto> results) {
		this.results = results;
	}
}

