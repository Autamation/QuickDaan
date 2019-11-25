/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.model.ProjectFeesRegistrationModel;
import com.crowd.funding.database.model.ProjectFeesRegistrationSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProjectFeesRegistration service. Represents a row in the &quot;cf_project_fees_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProjectFeesRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectFeesRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistrationImpl
 * @see ProjectFeesRegistration
 * @see ProjectFeesRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ProjectFeesRegistrationModelImpl extends BaseModelImpl<ProjectFeesRegistration>
	implements ProjectFeesRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project fees registration model instance should use the {@link ProjectFeesRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_project_fees_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "PROJECT_FEES_ID", Types.BIGINT },
			{ "CATEGORY_ID", Types.BIGINT },
			{ "PROJECT_ID", Types.BIGINT },
			{ "START_AMOUNT", Types.FLOAT },
			{ "END_AMOUNT", Types.FLOAT },
			{ "WITHDRAW_STATUS", Types.INTEGER },
			{ "DATE", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PROJECT_FEES_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CATEGORY_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PROJECT_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("START_AMOUNT", Types.FLOAT);
		TABLE_COLUMNS_MAP.put("END_AMOUNT", Types.FLOAT);
		TABLE_COLUMNS_MAP.put("WITHDRAW_STATUS", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("DATE", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_project_fees_details (uuid_ VARCHAR(75) null,PROJECT_FEES_ID LONG not null primary key,CATEGORY_ID LONG,PROJECT_ID LONG,START_AMOUNT DOUBLE,END_AMOUNT DOUBLE,WITHDRAW_STATUS INTEGER,DATE DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cf_project_fees_details";
	public static final String ORDER_BY_JPQL = " ORDER BY projectFeesRegistration.PROJECT_FEES_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_project_fees_details.PROJECT_FEES_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.ProjectFeesRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.ProjectFeesRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.ProjectFeesRegistration"),
			true);
	public static final long CATEGORY_ID_COLUMN_BITMASK = 1L;
	public static final long PROJECT_FEES_ID_COLUMN_BITMASK = 2L;
	public static final long PROJECT_ID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectFeesRegistration toModel(
		ProjectFeesRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectFeesRegistration model = new ProjectFeesRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setPROJECT_FEES_ID(soapModel.getPROJECT_FEES_ID());
		model.setCATEGORY_ID(soapModel.getCATEGORY_ID());
		model.setPROJECT_ID(soapModel.getPROJECT_ID());
		model.setSTART_AMOUNT(soapModel.getSTART_AMOUNT());
		model.setEND_AMOUNT(soapModel.getEND_AMOUNT());
		model.setWITHDRAW_STATUS(soapModel.getWITHDRAW_STATUS());
		model.setDATE(soapModel.getDATE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectFeesRegistration> toModels(
		ProjectFeesRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProjectFeesRegistration> models = new ArrayList<ProjectFeesRegistration>(soapModels.length);

		for (ProjectFeesRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.ProjectFeesRegistration"));

	public ProjectFeesRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PROJECT_FEES_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPROJECT_FEES_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PROJECT_FEES_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectFeesRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectFeesRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_FEES_ID", getPROJECT_FEES_ID());
		attributes.put("CATEGORY_ID", getCATEGORY_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("START_AMOUNT", getSTART_AMOUNT());
		attributes.put("END_AMOUNT", getEND_AMOUNT());
		attributes.put("WITHDRAW_STATUS", getWITHDRAW_STATUS());
		attributes.put("DATE", getDATE());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_FEES_ID = (Long)attributes.get("PROJECT_FEES_ID");

		if (PROJECT_FEES_ID != null) {
			setPROJECT_FEES_ID(PROJECT_FEES_ID);
		}

		Long CATEGORY_ID = (Long)attributes.get("CATEGORY_ID");

		if (CATEGORY_ID != null) {
			setCATEGORY_ID(CATEGORY_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Float START_AMOUNT = (Float)attributes.get("START_AMOUNT");

		if (START_AMOUNT != null) {
			setSTART_AMOUNT(START_AMOUNT);
		}

		Float END_AMOUNT = (Float)attributes.get("END_AMOUNT");

		if (END_AMOUNT != null) {
			setEND_AMOUNT(END_AMOUNT);
		}

		Integer WITHDRAW_STATUS = (Integer)attributes.get("WITHDRAW_STATUS");

		if (WITHDRAW_STATUS != null) {
			setWITHDRAW_STATUS(WITHDRAW_STATUS);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getPROJECT_FEES_ID() {
		return _PROJECT_FEES_ID;
	}

	@Override
	public void setPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		_columnBitmask |= PROJECT_FEES_ID_COLUMN_BITMASK;

		if (!_setOriginalPROJECT_FEES_ID) {
			_setOriginalPROJECT_FEES_ID = true;

			_originalPROJECT_FEES_ID = _PROJECT_FEES_ID;
		}

		_PROJECT_FEES_ID = PROJECT_FEES_ID;
	}

	public long getOriginalPROJECT_FEES_ID() {
		return _originalPROJECT_FEES_ID;
	}

	@JSON
	@Override
	public long getCATEGORY_ID() {
		return _CATEGORY_ID;
	}

	@Override
	public void setCATEGORY_ID(long CATEGORY_ID) {
		_columnBitmask |= CATEGORY_ID_COLUMN_BITMASK;

		if (!_setOriginalCATEGORY_ID) {
			_setOriginalCATEGORY_ID = true;

			_originalCATEGORY_ID = _CATEGORY_ID;
		}

		_CATEGORY_ID = CATEGORY_ID;
	}

	public long getOriginalCATEGORY_ID() {
		return _originalCATEGORY_ID;
	}

	@JSON
	@Override
	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_columnBitmask |= PROJECT_ID_COLUMN_BITMASK;

		if (!_setOriginalPROJECT_ID) {
			_setOriginalPROJECT_ID = true;

			_originalPROJECT_ID = _PROJECT_ID;
		}

		_PROJECT_ID = PROJECT_ID;
	}

	public long getOriginalPROJECT_ID() {
		return _originalPROJECT_ID;
	}

	@JSON
	@Override
	public float getSTART_AMOUNT() {
		return _START_AMOUNT;
	}

	@Override
	public void setSTART_AMOUNT(float START_AMOUNT) {
		_START_AMOUNT = START_AMOUNT;
	}

	@JSON
	@Override
	public float getEND_AMOUNT() {
		return _END_AMOUNT;
	}

	@Override
	public void setEND_AMOUNT(float END_AMOUNT) {
		_END_AMOUNT = END_AMOUNT;
	}

	@JSON
	@Override
	public int getWITHDRAW_STATUS() {
		return _WITHDRAW_STATUS;
	}

	@Override
	public void setWITHDRAW_STATUS(int WITHDRAW_STATUS) {
		_WITHDRAW_STATUS = WITHDRAW_STATUS;
	}

	@JSON
	@Override
	public Date getDATE() {
		return _DATE;
	}

	@Override
	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProjectFeesRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectFeesRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectFeesRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectFeesRegistrationImpl projectFeesRegistrationImpl = new ProjectFeesRegistrationImpl();

		projectFeesRegistrationImpl.setUuid(getUuid());
		projectFeesRegistrationImpl.setPROJECT_FEES_ID(getPROJECT_FEES_ID());
		projectFeesRegistrationImpl.setCATEGORY_ID(getCATEGORY_ID());
		projectFeesRegistrationImpl.setPROJECT_ID(getPROJECT_ID());
		projectFeesRegistrationImpl.setSTART_AMOUNT(getSTART_AMOUNT());
		projectFeesRegistrationImpl.setEND_AMOUNT(getEND_AMOUNT());
		projectFeesRegistrationImpl.setWITHDRAW_STATUS(getWITHDRAW_STATUS());
		projectFeesRegistrationImpl.setDATE(getDATE());

		projectFeesRegistrationImpl.resetOriginalValues();

		return projectFeesRegistrationImpl;
	}

	@Override
	public int compareTo(ProjectFeesRegistration projectFeesRegistration) {
		long primaryKey = projectFeesRegistration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectFeesRegistration)) {
			return false;
		}

		ProjectFeesRegistration projectFeesRegistration = (ProjectFeesRegistration)obj;

		long primaryKey = projectFeesRegistration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ProjectFeesRegistrationModelImpl projectFeesRegistrationModelImpl = this;

		projectFeesRegistrationModelImpl._originalUuid = projectFeesRegistrationModelImpl._uuid;

		projectFeesRegistrationModelImpl._originalPROJECT_FEES_ID = projectFeesRegistrationModelImpl._PROJECT_FEES_ID;

		projectFeesRegistrationModelImpl._setOriginalPROJECT_FEES_ID = false;

		projectFeesRegistrationModelImpl._originalCATEGORY_ID = projectFeesRegistrationModelImpl._CATEGORY_ID;

		projectFeesRegistrationModelImpl._setOriginalCATEGORY_ID = false;

		projectFeesRegistrationModelImpl._originalPROJECT_ID = projectFeesRegistrationModelImpl._PROJECT_ID;

		projectFeesRegistrationModelImpl._setOriginalPROJECT_ID = false;

		projectFeesRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectFeesRegistration> toCacheModel() {
		ProjectFeesRegistrationCacheModel projectFeesRegistrationCacheModel = new ProjectFeesRegistrationCacheModel();

		projectFeesRegistrationCacheModel.uuid = getUuid();

		String uuid = projectFeesRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projectFeesRegistrationCacheModel.uuid = null;
		}

		projectFeesRegistrationCacheModel.PROJECT_FEES_ID = getPROJECT_FEES_ID();

		projectFeesRegistrationCacheModel.CATEGORY_ID = getCATEGORY_ID();

		projectFeesRegistrationCacheModel.PROJECT_ID = getPROJECT_ID();

		projectFeesRegistrationCacheModel.START_AMOUNT = getSTART_AMOUNT();

		projectFeesRegistrationCacheModel.END_AMOUNT = getEND_AMOUNT();

		projectFeesRegistrationCacheModel.WITHDRAW_STATUS = getWITHDRAW_STATUS();

		Date DATE = getDATE();

		if (DATE != null) {
			projectFeesRegistrationCacheModel.DATE = DATE.getTime();
		}
		else {
			projectFeesRegistrationCacheModel.DATE = Long.MIN_VALUE;
		}

		return projectFeesRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", PROJECT_FEES_ID=");
		sb.append(getPROJECT_FEES_ID());
		sb.append(", CATEGORY_ID=");
		sb.append(getCATEGORY_ID());
		sb.append(", PROJECT_ID=");
		sb.append(getPROJECT_ID());
		sb.append(", START_AMOUNT=");
		sb.append(getSTART_AMOUNT());
		sb.append(", END_AMOUNT=");
		sb.append(getEND_AMOUNT());
		sb.append(", WITHDRAW_STATUS=");
		sb.append(getWITHDRAW_STATUS());
		sb.append(", DATE=");
		sb.append(getDATE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.ProjectFeesRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PROJECT_FEES_ID</column-name><column-value><![CDATA[");
		sb.append(getPROJECT_FEES_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CATEGORY_ID</column-name><column-value><![CDATA[");
		sb.append(getCATEGORY_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PROJECT_ID</column-name><column-value><![CDATA[");
		sb.append(getPROJECT_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>START_AMOUNT</column-name><column-value><![CDATA[");
		sb.append(getSTART_AMOUNT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>END_AMOUNT</column-name><column-value><![CDATA[");
		sb.append(getEND_AMOUNT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WITHDRAW_STATUS</column-name><column-value><![CDATA[");
		sb.append(getWITHDRAW_STATUS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DATE</column-name><column-value><![CDATA[");
		sb.append(getDATE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProjectFeesRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectFeesRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _PROJECT_FEES_ID;
	private long _originalPROJECT_FEES_ID;
	private boolean _setOriginalPROJECT_FEES_ID;
	private long _CATEGORY_ID;
	private long _originalCATEGORY_ID;
	private boolean _setOriginalCATEGORY_ID;
	private long _PROJECT_ID;
	private long _originalPROJECT_ID;
	private boolean _setOriginalPROJECT_ID;
	private float _START_AMOUNT;
	private float _END_AMOUNT;
	private int _WITHDRAW_STATUS;
	private Date _DATE;
	private long _columnBitmask;
	private ProjectFeesRegistration _escapedModel;
}