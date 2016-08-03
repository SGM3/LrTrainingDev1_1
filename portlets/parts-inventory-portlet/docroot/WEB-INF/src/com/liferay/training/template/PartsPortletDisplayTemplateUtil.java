package com.liferay.training.template;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;

public class PartsPortletDisplayTemplateUtil {
	
	public Manufacturer getManufacturer(long manufacturerId) {
		
		try {
			return ManufacturerLocalServiceUtil.getManufacturer(manufacturerId);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
			return null;
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
			return null;
		}
	}
	
	public static PartsPortletDisplayTemplateUtil getInstance() {
		
		return new PartsPortletDisplayTemplateUtil();
	}
	
	private static Log _log = LogFactoryUtil.getLog(PartsPortletDisplayTemplateUtil.class);
}