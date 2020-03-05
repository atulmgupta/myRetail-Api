package com.target.retail.service.retail;

import com.target.retail.entity.product.ProductDetail;
import com.target.retail.entity.product.PriceDetail;

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
	ProductDetail putProductDetailById(Integer id, ProductDetail productDetail);

	boolean addProduct(ProductDetail productDetail);

	PriceDetail addPrice(PriceDetail price);
}
