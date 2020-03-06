package com.target.retail.service.retail;

import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.PriceNotFoundException;
import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.repository.PriceRepository;
import com.target.retail.repository.ProductRepository;
import com.target.retail.service.product.RemoteProductService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 
 * @author atulgupta
 *
 */
@Service
public class RetailServiceImpl implements RetailService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	PriceRepository priceRepo;
	@Autowired
	RemoteProductService remoteService;

	@Override
	public ProductDetail getProductDetailById(Integer id) throws RetailException, ProductNotFoundException {
		try {
			String productName = remoteService.getProductNameById(id);			
			PriceDetail detail = getPriceDetailById(id);
			ProductDetail productDetail = new ProductDetail(id, productName, detail);
			return productDetail;
		} catch (RetailException | ProductNotFoundException e) {
			throw e;
		}catch(Exception e) {
			throw new RetailException(HttpStatus.NOT_FOUND.value(), "Internal server error");
		}
	}

	@Override
	public ProductDetail putProductDetailById(Integer id, ProductDetail productDetail)
			throws RetailException, ProductNotFoundException {
		String productName = remoteService.getProductNameById(id);
		return null;
	}

	@Override
	public boolean addProduct(ProductDetail productDetail) {
		if (!productRepository.existsById(productDetail.getId())) {
			productRepository.save(productDetail);
			return true;
		}
		return false;
	}

	@Override
	public PriceDetail addPrice(PriceDetail price) {

		return priceRepo.save(price);
	}

	@Override
	public PriceDetail getPriceDetailById(Integer id) throws PriceNotFoundException {
		Optional<PriceDetail> detail = priceRepo.findById(id);
		if(detail.isPresent())
			return detail.get();
		throw new PriceNotFoundException(HttpStatus.NOT_FOUND.value(), "Price not found");
	
	}

}
