create index IX_DBC67110 on Inventory_Manufacturer (groupId);

create index IX_F67A54AE on Inventory_Part (groupId);
create index IX_F67CB96E on Inventory_Part (manufacturerId, groupId);