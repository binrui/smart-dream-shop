package com.smart.shop.base.databind;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
import com.smart.shop.base.utils.DateTimeUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(DateTimeUtils.string2Date(text, "yyyy-MM-dd"));
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
