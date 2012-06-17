package net.fiive.intern.android.data;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseMigration {

	public int getVersion();
	public void execute(SQLiteDatabase db);


}
