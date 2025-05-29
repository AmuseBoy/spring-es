package com.amuseboy.springes.web;

import com.amuseboy.springes.dao.ProductRepository;
import com.amuseboy.springes.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.suggest.Completion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName: ProductController
 * @Description: TODO
 * @Author: 55285
 * @Date: 2025/5/27 14:14
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 🔹 添加商品
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product.setSuggest(new Completion(Collections.singletonList(product.getName())));
        return ResponseEntity.ok(productRepository.save(product));
    }

    // 🔹 获取所有商品
    @GetMapping
    public ResponseEntity<Iterable<Product>> listAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // 🔹 根据 ID 获取
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 删除商品
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // 🔹 更新商品
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        product.setSuggest(new Completion(Collections.singletonList(product.getName())));
        Product updated = productRepository.save(product);
        return ResponseEntity.ok(updated);
    }

    // 🔹 按名称搜索（Text 类型）
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String name) {
        List<Product> result = productRepository.findByName(name);
        return ResponseEntity.ok(result);
    }

    // 🔹 按标签搜索
    @GetMapping("/tag")
    public ResponseEntity<List<Product>> searchByTag(@RequestParam String tag) {
        return ResponseEntity.ok(productRepository.findByTags(tag));
    }

}
