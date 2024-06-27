package com.cryss.springjpamaterializedview.controller;


import com.cryss.springjpamaterializedview.model.recursiveentity.Employee;
import com.cryss.springjpamaterializedview.model.request.EmployeeDTO;
import com.cryss.springjpamaterializedview.repository.DepartmentRepository;
import com.cryss.springjpamaterializedview.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<ResponseIterableComponent> getCategories(@PathVariable Long id) {
//
//        try {
//
//            // FormVersion
//            Collection<Category> categories = new ArrayList<> ();
//            categories.add (categoryRepository.findById (id).get ());
//
//
//            // Forms with it's children
////            Collection<Category> categoriesChildren = categories.;
//
////            // Send Forms data
//            this.responseIterable.data = categories;
//            this.responseIterable.status = 200;
//            this.responseIterable.info = "success";
//            this.responseIterable.message = "Success on getting experimental form metadata data by Publication Type Code: " + id + ".";
////            this.commonSvc.setLogger(INFO, this.responseIterable.message);
//
//        } catch (Exception e) {
//            this.responseIterable.status = 400;
//            this.responseIterable.info = "error";
//            this.responseIterable.message = "Error on getting experimental form metadata data by Publication Type Code: " + id + ".";
////            this.commonSvc.setLogger(ERROR, this responseIterable.message, e);
//        }
//
//        return ResponseEntity.status (this.responseIterable.status).body (this.responseIterable);
//
////        return ResponseEntity.status(this.responseIterable.status).body(this.responseIterable);
//    }
//
//    // Other API endpoints
//
//
@RequestMapping(method = RequestMethod.GET)
@Transactional(readOnly = true)
public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page, @RequestParam(name = "size", defaultValue = "10", required = false) Integer size) {

    PageRequest pageRequest = PageRequest.of (page, size);
    return ResponseEntity.ok (employeeRepository.findAllEmployeePaginated (pageRequest));

// Other API endpoints
}
//
//    @RequestMapping(method = RequestMethod.GET)
//    @Transactional(readOnly = true)
//    public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
//                                                           @RequestParam(name = "size", defaultValue = "10", required = false) Integer size) {
//
//        final Page<Category> categories;
//
//        PageRequest pageRequest = PageRequest.of (page, size).withSort (Sort.Direction.ASC, "name");
//        List<Category> categoryList = categoryRepository.findAll ();
//
//        final int start = (int) pageRequest.getOffset();
//        final int end = Math.min((start + pageRequest.getPageSize()), categoryList.size());
//
//        if (CollectionUtils.isNotEmpty(categoryList)) {
//            categories = new PageImpl<>(categoryList.subList(start, end), pageRequest, categoryList.size());
//        } else {
//            categories = new PageImpl<> (categoryList, pageRequest, 0);
//        }
//
//        return ResponseEntity.ok (categoryRepository.findAllCategoryPaginated (pageRequest));
//
//// Other API endpoints
//    }
//
//    @PutMapping(value = "/{id}/parent/{parentId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Category saveParentCategory(
//            @PathVariable(name = "id") Long id,
//            @PathVariable(name = "parentId") Long parentId
//
// )  {
//
//        if(Objects.nonNull (id) && Objects.nonNull (parentId)) {
//
//          var parent =  categoryRepository.findById (parentId).orElseThrow (()-> new RuntimeException ("parent id nao encontrado"));
//
//          var chield = categoryRepository.findById (id).orElseThrow (()-> new RuntimeException ("parent id nao encontrado"));
//
//          chield.setParentCategory (parent);
//
//        return   categoryRepository.save (chield);
//
//        }else{
//            throw new RuntimeException ("OCORREU UM ERRO");
//        }
//
//
//
//// Other API endpoints
//    }
//
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee saveEmployee(@RequestBody EmployeeDTO employeeDTO)  {



        if (Objects.nonNull (employeeDTO)) {

            return employeeRepository.save (Employee.builder ()
                            .email (employeeDTO.getEmail ())
                            .verified (employeeDTO.getVerified ())
                            .name (employeeDTO.getName ())
                            .verificationToken (employeeDTO.getVerificationToken ())
                    .build ());


        } else {
            throw new RuntimeException ("OCORREU UM ERRO");
        }

// Other API endpoints
    }
//
//
//    @GetMapping("links")
//    public Page<Link> get(LinkSpecification specification, Pageable pageable) {
//
//        return linkRepository.findAll (specification, pageable);
//
//    }
//
//    @GetMapping("products/fail")
//    @Transactional(readOnly = true)
//    public List<Product> getAllProductsWithError() {
//
//            List<Product> productList = productRepository.findAll ();
//            return  productList;
//
//    }
//
//    @GetMapping("products/nmais")
//    @Transactional(readOnly = true)
//    public ProductResponseDetails getAllProductsWithErrorNmais1() {
//
//        ProductResponseDetails productResponseDetails = productMapper.toProductResponseDto (null, productRepository.findProductAndCategories ());
//        return  productResponseDetails;
//
//    }
//
//    @GetMapping("products/nmais_pageable")
//    @Transactional(readOnly = true)
//    public Page<ProductResponseDTO> getAllProductsWithErrorNmais1Pageable(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size) {
//
//        PageRequest pageRequest = PageRequest.of (page, size);
//
//        Page<Product> pageProduct = productRepository.findAll (pageRequest);
//
//        productRepository.findProductAndCategoriesPaginatedCorrect (pageProduct.stream ().collect(Collectors.toList()));
//
//        return  pageProduct.map (x -> ProductResponseDTO
//                .builder ()
//                .id (x.getId ())
//                .name (x.getName ())
//                .categories (x.getCategories ().stream ().map (c-> CategoryResponseDTO.builder ().name (c.getName ()).build ()).collect(Collectors.toSet()))
//                .build ());
//
//    }
//
//    @PostMapping("/{category_id}/product/{product_id}/fail")
//    @Transactional
//    public Product
//    bindCategoryFail(@Valid
//                 @PathVariable (name = "category_id", required = true) @NotBlank Long categoryId,
//                 @PathVariable(name = "product_id", required = true) @NotBlank Long productId
//    ) {
//
//        Product response =  productRepository.findById (productId).map (product -> {
//
//            //category already exists
//            Category category = categoryRepository.findById (categoryId).
//                    orElseThrow (()-> new RuntimeException ("Not found category with id = " + categoryId));
//
//            product.addCategory (category);
//            return productRepository.save (product);
//
//        }).orElseThrow (() -> new RuntimeException ("Not found product with id = " + productId));
//
//        return response;
//    }
//
//
//    @GetMapping("products")
//    @Transactional(readOnly = true)
//    public List<ProductResponseDTO> getAllProducts() {
//
//        List<ProductResponseDTO> productRequestDTOList = productRepository.findAll ().stream ().map (product -> {
//            return ProductResponseDTO.builder ().id (product.getId ()).name (product.getName ()).categories (product.getCategories ().stream ().map (category -> {
//                return CategoryResponseDTO.builder ().id (category.getId ())
////                                                                .parentCategory (ParentCategoryDTO
////                                                                        .builder()
////                                                                        .id (category.getParentCategory ().getId ())
////                                                                        .name (category.getParentCategory ().getName ())
////                                                                        .build())
//                        .name (category.getName ()).children (category.getChildren ().stream ().map (chield -> {
//                            return CategoryResponseDTO.builder ().id (chield.getId ()).name (chield.getName ()).children (toListCategoryResponseDTO (chield.getChildren ())).build ();
//                        }).collect (Collectors.toSet ())).build ();
//            }).collect (Collectors.toSet ())).build ();
//        }).toList ();
//
//        return productRequestDTOList;
//
//    }
//
//    @PostMapping("products")
//    public ProductResponseDTO saveProduct(@Valid @RequestBody ProductRequestDTO productRequest) {
//
//        Product product =
//                Product
//                .builder ()
//                        .name (productRequest.getName ())
//                .build ();
//
//
//        Product result = productRepository.save (product);
//
//        return ProductResponseDTO
//                .builder ()
//                .id (result.getId ())
//                .name (result.getName ())
//                .build ();
//
//
//    }
//
//    @PostMapping("/{category_id}/product/{product_id}")
//    public ProductResponseDTO
//    bindCategory(@Valid
//                 @PathVariable (name = "category_id", required = true) @NotBlank Long categoryId,
//                 @PathVariable(name = "product_id", required = true) @NotBlank Long productId
//    ) {
//
//        Category categoryInDB = categoryRepository.findById (categoryId)
//                .orElseThrow (()-> new RuntimeException ("Categoria não encontrada!"));
//
//
//
//        Product productInDB = productRepository.findById (productId)
//                .orElseThrow (()-> new RuntimeException ("Produto não encontrado!"));
//
//        productInDB.addCategory (categoryInDB);
//
//
//        Product result = productRepository.save (productInDB);
//        return ProductResponseDTO
//                .builder ()
//                .id (result.getId ())
//                .name (result.getName ())
//                .categories (productInDB.getCategories()
//                        .stream ()
//                        .map (category -> {
//                            return CategoryResponseDTO
//                                    .builder ()
//                                    .id (category.getId ())
//                                    .parentCategory (ParentCategoryDTO
//                                            .builder()
//                                            .id (category.getParentCategory ().getId ())
//                                            .name (category.getParentCategory ().getName ())
//                                            .build())
//                                    .name (category.getName ())
//                                //    .children (category.getChildren ())
//                                    .build ();
//                        }).collect(Collectors.toSet()))
//                .build ();
//
//
//    }
//
//    private Set<CategoryResponseDTO> toListCategoryResponseDTO(Collection<Category> category){
//     return   category.stream()
//                .map (chield->{
//                    return CategoryResponseDTO
//                            .builder ()
//                            .id (chield.getId ())
//                            .name (chield.getName ())
//                            .children (toListCategoryResponseDTO(chield.getChildren ()))
//                            .build ();
//                }).collect(Collectors.toSet());
//    }
//
//
//
}




