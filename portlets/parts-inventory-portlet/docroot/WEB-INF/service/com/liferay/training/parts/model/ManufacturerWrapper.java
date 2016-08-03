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
 * This class is a wrapper for {@link Manufacturer}.
 * </p>
 *
 * @author Shanon Mathai
 * @see Manufacturer
 * @generated
 */
public class ManufacturerWrapper implements Manufacturer,
	ModelWrapper<Manufacturer> {
	public ManufacturerWrapper(Manufacturer manufacturer) {
		_manufacturer = manufacturer;
	}

	@Override
	public Class<?> getModelClass() {
		return Manufacturer.class;
	}

	@Override
	public String getModelClassName() {
		return Manufacturer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("manufacturerId", getManufacturerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("website", getWebsite());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long manufacturerId = (Long)attributes.get("manufacturerId");

		if (manufacturerId != null) {
			setManufacturerId(manufacturerId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
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
	* Returns the primary key of this manufacturer.
	*
	* @return the primary key of this manufacturer
	*/
	@Override
	public long getPrimaryKey() {
		return _manufacturer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this manufacturer.
	*
	* @param primaryKey the primary key of this manufacturer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_manufacturer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the manufacturer ID of this manufacturer.
	*
	* @return the manufacturer ID of this manufacturer
	*/
	@Override
	public long getManufacturerId() {
		return _manufacturer.getManufacturerId();
	}

	/**
	* Sets the manufacturer ID of this manufacturer.
	*
	* @param manufacturerId the manufacturer ID of this manufacturer
	*/
	@Override
	public void setManufacturerId(long manufacturerId) {
		_manufacturer.setManufacturerId(manufacturerId);
	}

	/**
	* Returns the company ID of this manufacturer.
	*
	* @return the company ID of this manufacturer
	*/
	@Override
	public long getCompanyId() {
		return _manufacturer.getCompanyId();
	}

	/**
	* Sets the company ID of this manufacturer.
	*
	* @param companyId the company ID of this manufacturer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_manufacturer.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this manufacturer.
	*
	* @return the group ID of this manufacturer
	*/
	@Override
	public long getGroupId() {
		return _manufacturer.getGroupId();
	}

	/**
	* Sets the group ID of this manufacturer.
	*
	* @param groupId the group ID of this manufacturer
	*/
	@Override
	public void setGroupId(long groupId) {
		_manufacturer.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this manufacturer.
	*
	* @return the user ID of this manufacturer
	*/
	@Override
	public long getUserId() {
		return _manufacturer.getUserId();
	}

	/**
	* Sets the user ID of this manufacturer.
	*
	* @param userId the user ID of this manufacturer
	*/
	@Override
	public void setUserId(long userId) {
		_manufacturer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this manufacturer.
	*
	* @return the user uuid of this manufacturer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _manufacturer.getUserUuid();
	}

	/**
	* Sets the user uuid of this manufacturer.
	*
	* @param userUuid the user uuid of this manufacturer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_manufacturer.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this manufacturer.
	*
	* @return the name of this manufacturer
	*/
	@Override
	public java.lang.String getName() {
		return _manufacturer.getName();
	}

	/**
	* Sets the name of this manufacturer.
	*
	* @param name the name of this manufacturer
	*/
	@Override
	public void setName(java.lang.String name) {
		_manufacturer.setName(name);
	}

	/**
	* Returns the email address of this manufacturer.
	*
	* @return the email address of this manufacturer
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _manufacturer.getEmailAddress();
	}

	/**
	* Sets the email address of this manufacturer.
	*
	* @param emailAddress the email address of this manufacturer
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_manufacturer.setEmailAddress(emailAddress);
	}

	/**
	* Returns the website of this manufacturer.
	*
	* @return the website of this manufacturer
	*/
	@Override
	public java.lang.String getWebsite() {
		return _manufacturer.getWebsite();
	}

	/**
	* Sets the website of this manufacturer.
	*
	* @param website the website of this manufacturer
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_manufacturer.setWebsite(website);
	}

	/**
	* Returns the phone number of this manufacturer.
	*
	* @return the phone number of this manufacturer
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _manufacturer.getPhoneNumber();
	}

	/**
	* Sets the phone number of this manufacturer.
	*
	* @param phoneNumber the phone number of this manufacturer
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_manufacturer.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the create date of this manufacturer.
	*
	* @return the create date of this manufacturer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _manufacturer.getCreateDate();
	}

	/**
	* Sets the create date of this manufacturer.
	*
	* @param createDate the create date of this manufacturer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_manufacturer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this manufacturer.
	*
	* @return the modified date of this manufacturer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _manufacturer.getModifiedDate();
	}

	/**
	* Sets the modified date of this manufacturer.
	*
	* @param modifiedDate the modified date of this manufacturer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_manufacturer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user name of this manufacturer.
	*
	* @return the user name of this manufacturer
	*/
	@Override
	public java.lang.String getUserName() {
		return _manufacturer.getUserName();
	}

	/**
	* Sets the user name of this manufacturer.
	*
	* @param userName the user name of this manufacturer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_manufacturer.setUserName(userName);
	}

	@Override
	public boolean isNew() {
		return _manufacturer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_manufacturer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _manufacturer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_manufacturer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _manufacturer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _manufacturer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_manufacturer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _manufacturer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_manufacturer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_manufacturer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_manufacturer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ManufacturerWrapper((Manufacturer)_manufacturer.clone());
	}

	@Override
	public int compareTo(
		com.liferay.training.parts.model.Manufacturer manufacturer) {
		return _manufacturer.compareTo(manufacturer);
	}

	@Override
	public int hashCode() {
		return _manufacturer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.training.parts.model.Manufacturer> toCacheModel() {
		return _manufacturer.toCacheModel();
	}

	@Override
	public com.liferay.training.parts.model.Manufacturer toEscapedModel() {
		return new ManufacturerWrapper(_manufacturer.toEscapedModel());
	}

	@Override
	public com.liferay.training.parts.model.Manufacturer toUnescapedModel() {
		return new ManufacturerWrapper(_manufacturer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _manufacturer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _manufacturer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_manufacturer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ManufacturerWrapper)) {
			return false;
		}

		ManufacturerWrapper manufacturerWrapper = (ManufacturerWrapper)obj;

		if (Validator.equals(_manufacturer, manufacturerWrapper._manufacturer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Manufacturer getWrappedManufacturer() {
		return _manufacturer;
	}

	@Override
	public Manufacturer getWrappedModel() {
		return _manufacturer;
	}

	@Override
	public void resetOriginalValues() {
		_manufacturer.resetOriginalValues();
	}

	private Manufacturer _manufacturer;
}