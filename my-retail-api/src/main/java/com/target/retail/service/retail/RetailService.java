package com.target.retail.service.retail;

import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.PriceNotFoundException;
import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;

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
	 * @throws RetailException 
	 * @throws ProductNotFoundException 
	 * @throws Exception 
	 */
	ProductDetail getProductDetailById(Integer id) throws RetailException, ProductNotFoundException, Exception;

	/**
	 * 
	 * @param id
	 * @param productDetail
	 * @return
	 * @throws RetailException 
	 * @throws ProductNotFoundException 
	 */
	boolean putProductDetailById(Integer id, ProductDetail productDetail) throws RetailException, ProductNotFoundException;

	boolean addProduct(ProductDetail productDetail);

	PriceDetail addPrice(PriceDetail price);
	
	
	PriceDetail getPriceDetailById(Integer id) throws PriceNotFoundException;
}
