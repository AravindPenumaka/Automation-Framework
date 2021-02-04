package testCases;

import java.sql.Connection;

import org.testng.annotations.Test;

import utilities.DBConnection;

public class TestDatabaseConnectivity {

	
	//@Test
	public void getDBData(){
		DBConnection dbCon = new DBConnection();
		Connection getCon = dbCon.getDBConnection();
		
		String SQLQuery = "SELECT DOS.* FROM DOSSIER DOS      -- Contract"+
		     ", DOSPHASE DPH     -- Contract Phase"+
		"WHERE DOS.DOSID = DPH.DOSID"+
		   "AND DPH.PHACODE = 'ES' -- Phase Code(ES:Active, TER:Terminated)"+
		   "AND DPH.JALCODE = 'ES' -- Step Code(ES:Active, FIN:Finished, ...)"+
		   "AND DPH.DPHDTFIN IS NULL -- Last phase has no finished date"+
		   "--AND DOS.TACCODE = 'PRET' -- Taccode (PRET:Retail, LOCFIN:Lease)"+
		   "and dosdpd >30"+   
		   "AND DPH.DPHDTEFFET >= SYSDATE - 100"+
		   "order by DOSNUM desc;";

		   
//		dbCon.executeSQLQuery(getCon , "select * from dossier WHERE dosid='4445536'");
		dbCon.getColumnNameByExecuteSQLQuery(getCon , SQLQuery);
		dbCon.closeDBConnection();
	}
	
	@Test
	public void getDBData1(){
		DBConnection dbCon = new DBConnection();
		Connection getCon = dbCon.getDBConnection();
		
		String SQLQuery = "SELECT PRECODESTATE,DOSNUM  FROM DOSSIER WHERE PRECODESTATE='DC'";
		dbCon.executeSQLQuery(getCon , SQLQuery, "PRECODESTATE", "DOSNUM");
		dbCon.closeDBConnection();
	}
}
