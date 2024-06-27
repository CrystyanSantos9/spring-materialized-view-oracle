//package com.cryss.tipsandlearnings.controller.mapper;
//
//import com.cryss.tipsandlearnings.model.recursiveentity.Product;
//import org.mapstruct.Builder;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
//
//public interface ProductMapper {
//
//    @Mapping (target = "data", source = "productList")
//    ProductResponseDetails toProductResponseDto(Integer dummy, List<Product> productList);
//
//}
