package db.migration;

import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2__Annonymize extends BaseJavaMigration{

	public void migrate(Context context) throws Exception {
		try (Statement select = context.getConnection().createStatement()){
			
			try (ResultSet rows = select.executeQuery("SELECT id,name,price FROM product ORDER BY id")){
				
				while(rows.next()) {
					
					int id = rows.getInt(1);
					
					String anonymizedName = "Anonymous" + id;
					
					try (Statement update = context.getConnection().createStatement()){
						
						update.execute("UPDATE product SET name = '"+ anonymizedName + "' WHERE id=" + id);
						
					}
				}
			}
		}
		
	}
	
}
