package com.target.retail.service.retail;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;
import com.target.retail.repository.ProductRepository;
import com.target.retail.service.product.RemoteProductService;

/**
 * 
 * @author atulgupta
 *
 */
@Service
@Scope("prototype")
public class RetailServiceImpl implements RetailService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	RemoteProductService remoteService;

	@Override
	public ProductDetail getProductDetailById(Integer id) throws Exception {
		try {
			String productName = remoteService.getProductNameById(id);
			Optional<ProductDetail> detail = productRepository.findById(id);
			if (!detail.isPresent())
				throw new ProductNotFoundException(HttpStatus.NOT_FOUND.value(), "Price detail not found");
			detail.get().setName(productName);
			return detail.get();
		} catch (RetailException | ProductNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RetailException(HttpStatus.NOT_FOUND.value(), "Internal server error");
		}
	}

	@Override
	public boolean putProductDetailById(Integer id, ProductDetail productDetail)
			throws RetailException, ProductNotFoundException {

		ProductDetail res = productRepository.save(productDetail);
		if (res != null)
			return true;

		return false;

	}

	@Override
	public boolean addProduct(ProductDetail productDetail) {
		if (!productRepository.existsById(productDetail.getId())) {
			productRepository.save(productDetail);
			return true;
		}
		return false;
	}

}
