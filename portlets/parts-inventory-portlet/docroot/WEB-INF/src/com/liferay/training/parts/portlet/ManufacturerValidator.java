package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.parts.model.Manufacturer;

import java.util.List;

public class ManufacturerValidator {
	/**
	 * Verify manufacturer
	 * 
	 * @param manufacturer
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public static boolean validateManufacturer(Manufacturer manufacturer, List errors) {
		boolean valid = true;

		if (Validator.isNull(manufacturer.getName())) {
			errors.add("manufacturername-required");
			valid = false;
		}

		if (Validator.isNull(manufacturer.getEmailAddress())) {
			errors.add("manufactureremail-required");
			valid = false;
		}

		if (!Validator.isEmailAddress(manufacturer.getEmailAddress())) {
			errors.add("manufactureremail-format-error");
			valid = false;
		}

		if (Validator.isNull(manufacturer.getPhoneNumber())) {
			errors.add("manufacturerphonenumber-required");
			valid = false;
		}

		if (!Validator.isPhoneNumber(manufacturer.getPhoneNumber())) {
			errors.add("manufacturerphonenumber-format-error");
			valid = false;
		}

		return valid;
	}

}