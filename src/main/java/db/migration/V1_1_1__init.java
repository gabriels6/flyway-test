package db.migration;

import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;


public class V1_1_1__init extends BaseJavaMigration{

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		String createProductSQL = "CREATE TABLE product(\r\n"
				+ "    id SERIAL PRIMARY KEY ,\r\n"
				+ "    name varchar(255),\r\n"
				+ "    price double precision\r\n"
				+ ");";
		
		Statement create = context.getConnection().createStatement();
		create.execute(createProductSQL);
	}
	

}
