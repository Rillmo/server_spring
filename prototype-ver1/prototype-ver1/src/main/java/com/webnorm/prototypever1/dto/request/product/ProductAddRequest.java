package com.webnorm.prototypever1.dto.request.product;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.webnorm.prototypever1.dto.request.RequestInterface;
import com.webnorm.prototypever1.entity.product.Product;
import com.webnorm.prototypever1.entity.product.Size;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductAddRequest implements RequestInterface {
    private String name;
    private String color;
    private int price;
    private List<Size> sizeList;
    private String details;
    private String shipping;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .color(color)
                .price(price)
                .sizeList(sizeList)
                .details(details)
                .shipping(shipping)
                .build();
    }
}
