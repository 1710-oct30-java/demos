package assignments.week01.project.migration;

import java.util.ArrayList;
import java.util.List;

/**
 * bundles the initial migrations to perform to 
 * generate the initial data set for the application
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class BootstrapAppData extends AbstractMigration 
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		List<MigrationInterface> migrations = new ArrayList<>();
		
		migrations.add( new DropPeopleTable() );
		migrations.add( new DropUsersTable() );
		migrations.add( new DropAccountsTable() );
		migrations.add( new DropTransactionsTable());
		
		migrations.add( new Vacuum() );
		
		migrations.add( new CreatePeopleTable() );
		migrations.add( new CreateUsersTable() );
		migrations.add( new CreateAccountsTable() );
		migrations.add( new CreateTransactionsTable() );
		
		migrations.add( new InitializePeopleTable() );
		migrations.add( new InitializeUsersTable() );
		migrations.add( new InitializeAccountsTable() );
		migrations.add( new InitializeTransactionsTable() );
				
		for(MigrationInterface migration: migrations ) {
			migration.run();
		}		

	}
		


}
