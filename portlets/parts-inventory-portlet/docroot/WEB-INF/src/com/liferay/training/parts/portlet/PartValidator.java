package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.parts.model.Part;

import java.text.SimpleDateFormat;
import java.util.List;

public class PartValidator {

	/**
	 * Validate part
	 *
	 * @param part
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */

	public static boolean validatePart(Part part, List errors) {
		boolean valid = true;

		if (Validator.isNull(part.getName())) {
			errors.add("partname-required");
			valid = false;
		}

		if (Validator.isNull(part.getPartNumber())) {
			errors.add("partnumber-required");
			valid = false;
		}

		if (Validator.isNull(part.getOrderDate())) {
			errors.add("orderdate-required");
			valid = false;
		}
		
		if (Validator.isNull(part.getQuantity())) {
			errors.add("quantity-required");
			valid = false;
		}

		if (Validator.isNull(part.getManufacturerId())) {
			errors.add("manufacturer-required");
			valid = false;
		}

		return valid;
	}

	public static boolean validatePreferences(String rowsPerPage,
			String dateFormat, List errors) {

		boolean valid = true;

		if (Validator.isNull(rowsPerPage)) {
			errors.add("rowsperpage-required");
			valid = false;
		}
		else if (!Validator.isNumber(rowsPerPage)) {
			errors.add("rowsperpage-invalid");
			valid = false;
		}

		if (Validator.isNull(dateFormat)) {
			errors.add("dateformat-required");
			valid = false;
		}
		else {
			try {
				SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			}
			catch (Exception e) {
				errors.add("dateformat-invalid");
				valid = false;
			}
		}

		return valid;
	}

}