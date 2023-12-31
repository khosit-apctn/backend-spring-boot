package com.iamtraing.backend.business;

import com.iamtraing.backend.exception.BaseException;
import com.iamtraing.backend.exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBusiness {
    public String getProductBYID(String id) throws BaseException {
        // TODO: get data from Database
        if (Objects.equals("1234", id)) {
            throw ProductException.notFound();
        }
        return id;
    }
}
