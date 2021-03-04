package db.migration;

import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_2_1__AddProduct extends BaseJavaMigration{

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		
		String insertProductSQL = "INSERT INTO product(\"name\",\"price\") VALUES('Pen',1.5),('Book',15.0);";
		
		Statement insert = context.getConnection().createStatement();
		insert.execute(insertProductSQL);
	}

}
