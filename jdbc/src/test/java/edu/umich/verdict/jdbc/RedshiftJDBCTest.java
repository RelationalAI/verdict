package edu.umich.verdict.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import edu.umich.verdict.util.ResultSetConversion;

public class RedshiftJDBCTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.amazon.redshift.jdbc41.Driver");

		String url = "jdbc:redshift://salat2-verdict.ctkb4oe4rzfm.us-east-1.redshift.amazonaws.com:5439/dev?PWD=BTzyc1xG&UID=junhao";
		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement();
		
		// first query
		boolean isThereResult = stmt.execute("SELECT count(*) AS \"expr3\", count(distinct \"o_orderkey\") AS \"expr4\", count(distinct \"o_custkey\") AS \"expr5\", count(distinct \"o_orderstatus\") AS \"expr6\", count(distinct \"o_totalprice\") AS \"expr7\", count(distinct \"o_orderdate\") AS \"expr8\", count(distinct \"o_orderpriority\") AS \"expr9\", count(distinct \"o_clerk\") AS \"expr10\", count(distinct \"o_shippriority\") AS \"expr11\", count(distinct \"o_comment\") AS \"expr12\" FROM tpch1g_verdict.vs_orders_uf_0_0100 vt15");
		System.out.println(isThereResult);
		ResultSet rs = stmt.getResultSet();
		ResultSetConversion.printResultSet(rs);
		rs.close();
		
//		// second query
//		stmt.executeUpdate("create schema if not exists public_verdict");
//		
//		// third query
//		isThereResult = stmt.execute("select nspname from pg_namespace");
//		System.out.println(isThereResult);
//		rs = stmt.getResultSet();
//		ResultSetConversion.printResultSet(rs);
	}

}
