package net.fiive.intern.android.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class OpenHelper extends SQLiteOpenHelper {

	private MigrationManager migrationManager;

	public OpenHelper(android.content.Context context, String databaseName, int databaseVersion, DatabaseMigration createMigration, DatabaseMigration... upgradeMigrations) {
		super(context, databaseName, null, databaseVersion);
		this.migrationManager = new MigrationManager(createMigration, upgradeMigrations);

	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		migrationManager.createDatabase(sqLiteDatabase);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
		migrationManager.upgradeDatabase(sqLiteDatabase, oldVersion, newVersion);
	}
}
