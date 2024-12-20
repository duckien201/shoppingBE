package com.example.crud_test.service.impl;

import com.example.crud_test.constant.CreateNotification;
import com.example.crud_test.model.RateProduct;
import com.example.crud_test.repository.CategoryRepo;
import com.example.crud_test.repository.ProductRepository;
import com.example.crud_test.repository.RateRepository;
import com.example.crud_test.repository.UserRepository;
import com.example.crud_test.dto.ProductDto;
import com.example.crud_test.model.Product;
import com.example.crud_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.crud_test.constant.Constant.NOTI_ADMIN_NEW_PRODUCT;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private CategoryRepo categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<Product> getBestSeller() {
        List<Product> allProduct = productRepository.findAll();
        List<Product> filteredProducts = allProduct.stream()
                .filter(product -> product.getRemain() != 0 && product.getStatus().equals("ok"))
                .collect(Collectors.toList());
        filteredProducts.sort((o1, o2) -> Integer.compare(o2.getNumberOfSale(), o1.getNumberOfSale()));
        return filteredProducts.subList(0, 6);
    }

    @Override
    public Product getProduct(long id) {
        System.out.println(productRepository.findByIdProduct(id));
        return productRepository.findByIdProduct(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ResponseEntity<?> addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setShop(userRepository.findById(productDto.getIdShop()).get());
        product.setName(productDto.getName());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setMaterial(productDto.getMaterial());
        product.setRemain(productDto.getRemain());
        product.setSale(productDto.getSale());
        product.setCategory(categoryRepository.findById(productDto.getCategoryId()));
        product.setNumberOfSale(0);
        product.setStatus("Đang chờ duyệt");

        productRepository.save(product);
        createNotification.createNotification(10L, product.getImage().get(0), NOTI_ADMIN_NEW_PRODUCT, NOTI_ADMIN_NEW_PRODUCT, "/admin/products");
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductDto productDto) {
        Product product = productRepository.findByIdProduct(productDto.getIdProduct()).get();
        if (!product.getStatus().equals("Cấm")) {
            product.setName(productDto.getName());
            product.setImage(productDto.getImage());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setMaterial(productDto.getMaterial());
            product.setRemain(productDto.getRemain());
            product.setSale(productDto.getSale());
            product.setCategory(categoryRepository.findById(productDto.getCategoryId()));
            product.setStatus("Đang chờ duyệt");
            productRepository.save(product);
            createNotification.createNotification(10L, product.getImage().get(0), NOTI_ADMIN_NEW_PRODUCT, NOTI_ADMIN_NEW_PRODUCT, "/admin/products");
            return ResponseEntity.ok().body("Sửa sản phẩm thành công, hãy đợi phản hồi nhé");
        }
        return null;
    }

    @Override
    public List<Product> getAllProductOfShop(long id) {
        return productRepository.findByIdShop(id);
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<RateProduct> ratings = rateRepository.findAll();

        Map<Long, Double> productStars = ratings.stream()
                .collect(Collectors.groupingBy(rating -> rating.getProduct().getIdProduct(),
                        Collectors.averagingDouble(RateProduct::getStar)));

        // Add stars to products
        products.forEach(product -> {
            Double averageStars = productStars.get(product.getIdProduct());
            if (averageStars != null) {
                int roundedStars = (int) Math.round(averageStars);
                product.setStar(roundedStars);
            }
        });

        return products;
    }
}
