package com.target.retail.service.product;

import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;

/**
 * 
 * @author atulgupta
 *
 */
public interface RemoteProductService {
	String getProductNameById(Integer id) throws RetailException, ProductNotFoundException;
}
