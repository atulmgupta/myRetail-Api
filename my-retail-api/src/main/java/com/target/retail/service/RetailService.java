package com.target.retail.service;

import com.target.retail.entity.ProductDetail;
/**
 * 
 * @author atulgupta
 *
 */
public interface RetailService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductDetail getProductDetailById(Integer id);
	
	/**
	 * 
	 * @param id
	 * @param productDetail
	 * @return
	 */
	ProductDetail putProductDetailById(Integer id,ProductDetail productDetail);
}
