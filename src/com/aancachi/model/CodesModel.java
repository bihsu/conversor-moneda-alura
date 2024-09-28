package com.aancachi.model;

import java.util.Map;

public record CodesModel(
		String result,
		String documentation,
		String terms_of_use,
		Map<String, String> supported_codes
		) {

}
