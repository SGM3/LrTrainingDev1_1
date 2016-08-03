
package com.liferay.training.template;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;
import com.liferay.training.parts.model.Part;
import com.liferay.training.util.PortletKeys;
import com.liferay.util.portlet.PortletProps;

public class PartsPortletDisplayTemplateHandler extends
		BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		
		return Part.class.getName();
	}

	@Override
	public String getName(Locale locale) {

		String portletTitle = PortalUtil.getPortletTitle(PortletKeys.PARTS,
				locale);

		return portletTitle.concat(StringPool.SPACE).concat(
				LanguageUtil.get(locale, "template"));
	}

	@Override
	public String getResourceName() {
		
		return PortletKeys.PARTS;
	}
	
	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale) throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups = super
				.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup = templateVariableGroups
				.get("fields");

		templateVariableGroup.empty();

		templateVariableGroup.addCollectionVariable("parts", List.class,
				PortletDisplayTemplateConstants.ENTRIES, "part", Part.class,
				"curPart", "name");

		return templateVariableGroups;
	}
	
	@Override
	public String getTemplatesHelpPath(String language) {
		
		return PortletProps.get(getTemplatesHelpPropertyKey(), new Filter(
				language));
	}

	@Override
	public String getTemplatesHelpPropertyKey() {
		
		return "parts.portlet.display.templates.help";
	}

}
