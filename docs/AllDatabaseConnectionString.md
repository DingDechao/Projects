1. MySQL(http://www.mysql.com)mm.mysql-2.0.2-bin.jar
    Class.forName( "com.mysql.jdbc.Driver" );
    cn = DriverManager.getConnection( "jdbc:mysql://MyDbComputerNameOrIP:3306/myDatabaseName", sUsr, sPwd );

2. PostgreSQL(http://www.de.postgresql.org)pgjdbc2.jar
    Class.forName( "org.postgresql.Driver" );
    cn = DriverManager.getConnection( "jdbc:postgresql://MyDbComputerNameOrIP/myDatabaseName", sUsr, sPwd );

3. Oracle(http://www.oracle.com/ip/deploy/database/oracle9i/)classes12.zip
    Class.forName( "oracle.jdbc.driver.OracleDriver" );
    cn = DriverManager.getConnection( "jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL", sUsr, sPwd );

4. Sybase(http://jtds.sourceforge.net)jconn2.jar
    Class.forName( "com.sybase.jdbc2.jdbc.SybDriver" );
    cn = DriverManager.getConnection( "jdbc:sybase:Tds:MyDbComputerNameOrIP:2638", sUsr, sPwd );
    // (Default-Username/Password: "dba"/"sql")

5. Microsoft SQLServer(http://jtds.sourceforge.net)
    Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
    cn = DriverManager.getConnection( "jdbc:jtds:sqlserver://MyDbComputerNameOrIP:1433/master", sUsr, sPwd );

6. Microsoft SQLServer(http://www.microsoft.com)
    Class.forName( "com.microsoft.jdbc.sqlserver.SQLServerDriver" );
    cn = DriverManager.getConnection( "jdbc:sqlserver://MyDbComputerNameOrIP:1433;databaseName=master", sUsr, sPwd );

7. ODBC
    Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
    Connection cn = DriverManager.getConnection( "jdbc:odbc:" + sDsn, sUsr, sPwd );

8. DB2
    Class.forName("Com.ibm.db2.jdbc.net.DB2Driver");
    String url="jdbc:db2://192.9.200.108:6789/SAMPLE"
    cn = DriverManager.getConnection( url, sUsr, sPwd );

9. H2
    Class.forName( "" );
    cn = DriverManager.getConnection( "", sUsr, sPwd );
