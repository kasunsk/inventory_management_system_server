package com.kasun.userapp.inventory.logic;

import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.InventoryAddParam;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */

public class AddInventoryLogic implements InventoryLogic {

	private InventoryDao inventoryDao;

	public void saveInventory(InventoryAddParam addParam) {

		validate(addParam);
		inventoryDao.saveInventory(addParam);

	}

	private boolean validate(InventoryAddParam addParam) {

		if (addParam != null) {
			return false;
		}
		return true;
	}

	@Required
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
}
