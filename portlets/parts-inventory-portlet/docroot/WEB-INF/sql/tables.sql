create table Inventory_Manufacturer (
	manufacturerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	website VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	userName VARCHAR(75) null
);

create table Inventory_Part (
	partId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	manufacturerId LONG,
	name STRING null,
	partNumber VARCHAR(75) null,
	orderDate DATE null,
	quantity INTEGER,
	createDate DATE null,
	modifiedDate DATE null,
	userName VARCHAR(75) null
);