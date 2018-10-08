package com.okorkut.derby.dao.utils;

public enum DBType {
	OTHERS(0, "Undefined"), //
	DERBY(1, "Apache Derby"), //
	DB2(2, "IBM DB2"), //
	ORACLE(3, "Oracle"), //
	MSSQL(4, "Microsoft MsSQL Server");

	private int dbType;
	private String desc;

	private DBType(int dbType, String desc) {
		this.dbType = dbType;
		this.desc = desc;
	}

	public static DBType getDBTypeById(String dbType) throws Exception {
		int typeId = Integer.parseInt(dbType);
		return getDBTypeById(typeId);
	}

	public static DBType getDBTypeById(int dbType) throws Exception {
		switch (dbType) {
		case 1:
			return DBType.DERBY;
		case 2:
			return DBType.DB2;
		case 3:
			return DBType.ORACLE;
		case 4:
			return DBType.MSSQL;
		default:
			return DBType.OTHERS;

		}
	}

	public int getDbType() {
		return dbType;
	}

	public void setDbType(int dbType) {
		this.dbType = dbType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
