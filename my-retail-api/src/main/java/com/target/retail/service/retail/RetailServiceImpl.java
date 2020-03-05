package com.target.retail.service.retail;

import com.target.retail.entity.product.ProductDetail;
import com.target.retail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author atulgupta
 *
 */
@Service
public class RetailServiceImpl implements RetailService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductDetail getProductDetailById(Integer id) {
		return null;
	}

	@Override
	public ProductDetail putProductDetailById(Integer id, ProductDetail productDetail) {
		return null;
	}

	@Override
	public boolean addProduct(ProductDetail productDetail) {
		if(!productRepository.existsById(productDetail.getId())){
			productRepository.save(productDetail);
			return  true;
		}
		return false;
	}

}
