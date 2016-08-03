/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.parts.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Part}.
 * </p>
 *
 * @author Shanon Mathai
 * @see Part
 * @generated
 */
public class PartWrapper implements Part, ModelWrapper<Part> {
	public PartWrapper(Part part) {
		_part = part;
	}

	@Override
	public Class<?> getModelClass() {
		return Part.class;
	}

	@Override
	public String getModelClassName() {
		return Part.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partId", getPartId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("manufacturerId", getManufacturerId());
		attributes.put("name", getName());
		attributes.put("partNumber", getPartNumber());
		attributes.put("orderDate", getOrderDate());
		attributes.put("quantity", getQuantity());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long partId = (Long)attributes.get("partId");

		if (partId != null) {
			setPartId(partId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long manufacturerId = (Long)attributes.get("manufacturerId");

		if (manufacturerId != null) {
			setManufacturerId(manufacturerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String partNumber = (String)attributes.get("partNumber");

		if (partNumber != null) {
			setPartNumber(partNumber);
		}

		Date orderDate = (Date)attributes.get("orderDate");

		if (orderDate != null) {
			setOrderDate(orderDate);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	/**
	* Returns the primary key of this part.
	*
	* @return the primary key of this part
	*/
	@Override
	public long getPrimaryKey() {
		return _part.getPrimaryKey();
	}

	/**
	* Sets the primary key of this part.
	*
	* @param primaryKey the primary key of this part
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_part.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the part ID of this part.
	*
	* @return the part ID of this part
	*/
	@Override
	public long getPartId() {
		return _part.getPartId();
	}

	/**
	* Sets the part ID of this part.
	*
	* @param partId the part ID of this part
	*/
	@Override
	public void setPartId(long partId) {
		_part.setPartId(partId);
	}

	/**
	* Returns the company ID of this part.
	*
	* @return the company ID of this part
	*/
	@Override
	public long getCompanyId() {
		return _part.getCompanyId();
	}

	/**
	* Sets the company ID of this part.
	*
	* @param companyId the company ID of this part
	*/
	@Override
	public void setCompanyId(long companyId) {
		_part.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this part.
	*
	* @return the group ID of this part
	*/
	@Override
	public long getGroupId() {
		return _part.getGroupId();
	}

	/**
	* Sets the group ID of this part.
	*
	* @param groupId the group ID of this part
	*/
	@Override
	public void setGroupId(long groupId) {
		_part.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this part.
	*
	* @return the user ID of this part
	*/
	@Override
	public long getUserId() {
		return _part.getUserId();
	}

	/**
	* Sets the user ID of this part.
	*
	* @param userId the user ID of this part
	*/
	@Override
	public void setUserId(long userId) {
		_part.setUserId(userId);
	}

	/**
	* Returns the user uuid of this part.
	*
	* @return the user uuid of this part
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _part.getUserUuid();
	}

	/**
	* Sets the user uuid of this part.
	*
	* @param userUuid the user uuid of this part
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_part.setUserUuid(userUuid);
	}

	/**
	* Returns the manufacturer ID of this part.
	*
	* @return the manufacturer ID of this part
	*/
	@Override
	public long getManufacturerId() {
		return _part.getManufacturerId();
	}

	/**
	* Sets the manufacturer ID of this part.
	*
	* @param manufacturerId the manufacturer ID of this part
	*/
	@Override
	public void setManufacturerId(long manufacturerId) {
		_part.setManufacturerId(manufacturerId);
	}

	/**
	* Returns the name of this part.
	*
	* @return the name of this part
	*/
	@Override
	public java.lang.String getName() {
		return _part.getName();
	}

	/**
	* Returns the localized name of this part in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this part
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _part.getName(locale);
	}

	/**
	* Returns the localized name of this part in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this part. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _part.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this part in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this part
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _part.getName(languageId);
	}

	/**
	* Returns the localized name of this part in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this part
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _part.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _part.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _part.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this part.
	*
	* @return the locales and localized names of this part
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _part.getNameMap();
	}

	/**
	* Sets the name of this part.
	*
	* @param name the name of this part
	*/
	@Override
	public void setName(java.lang.String name) {
		_part.setName(name);
	}

	/**
	* Sets the localized name of this part in the language.
	*
	* @param name the localized name of this part
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_part.setName(name, locale);
	}

	/**
	* Sets the localized name of this part in the language, and sets the default locale.
	*
	* @param name the localized name of this part
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_part.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_part.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this part from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this part
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_part.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this part from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this part
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_part.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the part number of this part.
	*
	* @return the part number of this part
	*/
	@Override
	public java.lang.String getPartNumber() {
		return _part.getPartNumber();
	}

	/**
	* Sets the part number of this part.
	*
	* @param partNumber the part number of this part
	*/
	@Override
	public void setPartNumber(java.lang.String partNumber) {
		_part.setPartNumber(partNumber);
	}

	/**
	* Returns the order date of this part.
	*
	* @return the order date of this part
	*/
	@Override
	public java.util.Date getOrderDate() {
		return _part.getOrderDate();
	}

	/**
	* Sets the order date of this part.
	*
	* @param orderDate the order date of this part
	*/
	@Override
	public void setOrderDate(java.util.Date orderDate) {
		_part.setOrderDate(orderDate);
	}

	/**
	* Returns the quantity of this part.
	*
	* @return the quantity of this part
	*/
	@Override
	public int getQuantity() {
		return _part.getQuantity();
	}

	/**
	* Sets the quantity of this part.
	*
	* @param quantity the quantity of this part
	*/
	@Override
	public void setQuantity(int quantity) {
		_part.setQuantity(quantity);
	}

	/**
	* Returns the create date of this part.
	*
	* @return the create date of this part
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _part.getCreateDate();
	}

	/**
	* Sets the create date of this part.
	*
	* @param createDate the create date of this part
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_part.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this part.
	*
	* @return the modified date of this part
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _part.getModifiedDate();
	}

	/**
	* Sets the modified date of this part.
	*
	* @param modifiedDate the modified date of this part
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_part.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user name of this part.
	*
	* @return the user name of this part
	*/
	@Override
	public java.lang.String getUserName() {
		return _part.getUserName();
	}

	/**
	* Sets the user name of this part.
	*
	* @param userName the user name of this part
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_part.setUserName(userName);
	}

	@Override
	public boolean isNew() {
		return _part.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_part.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _part.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_part.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _part.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _part.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_part.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _part.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_part.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_part.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_part.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _part.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _part.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_part.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_part.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new PartWrapper((Part)_part.clone());
	}

	@Override
	public int compareTo(com.liferay.training.parts.model.Part part) {
		return _part.compareTo(part);
	}

	@Override
	public int hashCode() {
		return _part.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.training.parts.model.Part> toCacheModel() {
		return _part.toCacheModel();
	}

	@Override
	public com.liferay.training.parts.model.Part toEscapedModel() {
		return new PartWrapper(_part.toEscapedModel());
	}

	@Override
	public com.liferay.training.parts.model.Part toUnescapedModel() {
		return new PartWrapper(_part.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _part.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _part.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_part.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PartWrapper)) {
			return false;
		}

		PartWrapper partWrapper = (PartWrapper)obj;

		if (Validator.equals(_part, partWrapper._part)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Part getWrappedPart() {
		return _part;
	}

	@Override
	public Part getWrappedModel() {
		return _part;
	}

	@Override
	public void resetOriginalValues() {
		_part.resetOriginalValues();
	}

	private Part _part;
}