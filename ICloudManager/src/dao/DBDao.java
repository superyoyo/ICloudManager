package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import bean.Author;
import db.TableName;
import util.DBUtil;

public class DBDao {

	/**
	 * 向数据库添加数据，并返回主键ID
	 * @param tableName 要添加的表名
	 * @param params key：数据库字段   value:数据库字段的值
	 * @return 主键ID
	 * @throws SQLException
	 */
	public static int insert(String tableName, HashMap<String, Object> params) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into " + tableName);
		Iterator<String> it = params.keySet().iterator();
		
		StringBuilder fileds = new StringBuilder("");
		StringBuilder values = new StringBuilder("");
		
		fileds.append("(");
		values.append("(");
		
		while(it.hasNext()){
			String key = it.next();
			Object value = params.get(key);
			if(fileds.length() == 1){
				fileds.append(" " + key + " ");
			}else{
				fileds.append(" , " + key + " ");
			}
			
			if(values.length() == 1){
				if(value instanceof String){
					values.append(" " + value + " ");
				}else{
					values.append(" '" + value + "' ");
				}
			}else{
				if(value instanceof String){
					values.append(" ,'" + value + "' ");
				}else{
					values.append(" ," + value + " ");
				}
			}
		}
		
		fileds.append(")");
		values.append(")");
		
		sql.append(fileds);
		sql.append(" values ");
		sql.append(values);
		
		System.out.println("insert sql:" + sql.toString());
		
		Connection conn = DBUtil.getConnect();
		Statement st = conn.createStatement();
		st.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		int autoIncKeyFromApi = -1;
		ResultSet rs = st.getGeneratedKeys();// 获取自增主键！

		if (rs.next()) {
			autoIncKeyFromApi = rs.getInt(1);
		}
		rs.close();
		rs = null;
		return autoIncKeyFromApi;
	}
	
    /**
     * 修改指定参数
     * @param tableName 数据库表名
     * @param params key：数据库字段   value:数据库字段的值（不包含主键）
     * @param Id 主键的名字  
     * @param id 主键的值
     * @return 更新的数据库行数
     * @throws SQLException
     */
	public static int update(String tableName, HashMap<String, Object> params, String Id, Object id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update " + tableName + " ");
		Iterator<String> it = params.keySet().iterator();
		
		StringBuilder fileds = new StringBuilder("");
		
		while(it.hasNext()){
			String key = it.next();
			Object value = params.get(key);
			if(fileds.length() == 0){
				if(value instanceof String){
					fileds.append("set " + key + "=" + "'"+ value +"' ");
				}else{
					fileds.append("set " + key + "=" + value + " ");
				}
				
			}else{
				if(value instanceof String){
					fileds.append(", " + key + "=" + "'"+ value +"' ");
				}else{
					fileds.append(", " + key + "=" + value + " ");
				}
			}
		}
		sql.append(fileds);
		if(id instanceof String){
			sql.append(" where "+ Id +"='" + id + "'");
		}else{
			sql.append(" where "+ Id +"=" + id);
		}
		
		
		System.out.println("update sql:" + sql.toString());
		
		Connection conn = DBUtil.getConnect();
		if(conn != null){
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql.toString());
			st.close();
			conn.close();
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		HashMap<String, Object> insert = new HashMap<String, Object>();
		insert.put("name", "JackLee");
		insert.put("password", "12345");
		insert.put("age", 25);
		try {
			DBDao.insert("User", insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HashMap<String, Object> update = new HashMap<String, Object>();
		update.put("name", "JackLee");
		update.put("password", "12345");
		update.put("age", 25);
		
		try {
			DBDao.update("User", insert, "id", 3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
