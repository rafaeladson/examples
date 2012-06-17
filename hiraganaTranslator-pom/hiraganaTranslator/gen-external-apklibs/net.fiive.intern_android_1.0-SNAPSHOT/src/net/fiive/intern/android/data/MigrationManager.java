package net.fiive.intern.android.data;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Preconditions;
import net.fiive.intern.basic.PreconditionsExtensions;

class MigrationManager {

	private final DatabaseMigration createMigration;
	private final DatabaseMigration[] upgradeMigrations;

	public MigrationManager(DatabaseMigration createMigration, DatabaseMigration...upgradeMigrations) {
		Preconditions.checkNotNull(createMigration, "Error: createMigration cannot be null");
		this.createMigration = createMigration;

		this.upgradeMigrations = (upgradeMigrations != null ) ? upgradeMigrations : new DatabaseMigration[] {};
		PreconditionsExtensions.checkDoesNotContainNull(this.upgradeMigrations, "Error: upgradeMigrations cannot contain null element");

		checkAllUpgradeMigrationsHaveNonNegativeVersions();
	}


	public void createDatabase(SQLiteDatabase db) {
		this.createMigration.execute(db);
	}

	public void upgradeDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
		Preconditions.checkArgument(oldVersion >= 0, "Error: Old version should be greater or equal than zero");
		Preconditions.checkArgument(newVersion >= oldVersion, "Error: New version should be greater or equal than Old Version");
		for (DatabaseMigration migration : upgradeMigrations) {
			int migrationVersion = migration.getVersion();
			if (migrationVersion > oldVersion && migrationVersion <= newVersion) {
				migration.execute(db);
			}
		}
	}

	private void checkAllUpgradeMigrationsHaveNonNegativeVersions() {
		for (DatabaseMigration migration : this.upgradeMigrations) {
			if( migration.getVersion() < 0 ) {
				throw new IllegalArgumentException(String.format("Error: Migration %s must not have version less than zero", migration));
			}
		}
	}

}
