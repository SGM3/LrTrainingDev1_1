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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Shanon Mathai
 * @generated
 */
public class ManufacturerSoap implements Serializable {
	public static ManufacturerSoap toSoapModel(Manufacturer model) {
		ManufacturerSoap soapModel = new ManufacturerSoap();

		soapModel.setManufacturerId(model.getManufacturerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static ManufacturerSoap[] toSoapModels(Manufacturer[] models) {
		ManufacturerSoap[] soapModels = new ManufacturerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ManufacturerSoap[][] toSoapModels(Manufacturer[][] models) {
		ManufacturerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ManufacturerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ManufacturerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ManufacturerSoap[] toSoapModels(List<Manufacturer> models) {
		List<ManufacturerSoap> soapModels = new ArrayList<ManufacturerSoap>(models.size());

		for (Manufacturer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ManufacturerSoap[soapModels.size()]);
	}

	public ManufacturerSoap() {
	}

	public long getPrimaryKey() {
		return _manufacturerId;
	}

	public void setPrimaryKey(long pk) {
		setManufacturerId(pk);
	}

	public long getManufacturerId() {
		return _manufacturerId;
	}

	public void setManufacturerId(long manufacturerId) {
		_manufacturerId = manufacturerId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private long _manufacturerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _emailAddress;
	private String _website;
	private String _phoneNumber;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userName;
}