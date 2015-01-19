package com.kasun.userapp.inventory.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.model.Inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */
public class InventoryJDBCDao implements InventoryDao {

	private static final Logger log = LoggerFactory
			.getLogger(InventoryJDBCDao.class);

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public Void saveInventory(InventoryAddParam addParam) {

		String sql = "INSERT INTO inventoryData VALUES (?, ?, ?, ?,?,?)";
		jdbcTemplateObject.update(sql, addParam.getInventoryId(),
				addParam.getName(),  Integer.parseInt(addParam.getPrice()),
				addParam.getHospital(), addParam.getUserNote(), new Date());

		log.info("Inventory Saved Succesfully");
		return new Void();
		
	}
	
	@Override
	public List<Inventory> search(InventorySearchCriteria searchCriteria) {
		
		List<Inventory> searchResults = new ArrayList<>();
		String sql =  "SELECT * FROM inventoryData WHERE Inventory_Id = ?";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,searchCriteria.getInventoryId());
		
		for (@SuppressWarnings("rawtypes") Map row : rows) {
			
			Inventory inventory = new Inventory();
			inventory.setInventoryId((String)(row.get("Inventory_Id")));
			inventory.setName((String)(row.get("Name")));
			inventory.setPrice((Integer)(row.get("Price")));
			inventory.setHospital((String)(row.get("Hospital")));
			inventory.setUserNote((String)(row.get("User_Note")));
			inventory.setCreatedDate((Date)(row.get("Created_Date")));
			
			searchResults.add(inventory);
			
		}		
		return searchResults;
	}

	@Override
	public Set<InventoryAddParam> getInventoryById(String inventoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Required
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplateObject;
	}

	@Override
	public List<Inventory> viewAll() {
		
		List<Inventory> searchResults = new ArrayList<>();
		String sql =  "SELECT * FROM inventoryData ";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		for (@SuppressWarnings("rawtypes") Map row : rows) {
			
			Inventory inventory = new Inventory();
			inventory.setInventoryId((String)(row.get("Inventory_Id")));
			inventory.setName((String)(row.get("Name")));
			inventory.setPrice((Integer)(row.get("Price")));
			inventory.setHospital((String)(row.get("Hospital")));
			inventory.setUserNote((String)(row.get("User_Note")));
			inventory.setCreatedDate((Date)(row.get("Created_Date")));
			
			searchResults.add(inventory);
			
		}		
		return searchResults;
	}
	
}
