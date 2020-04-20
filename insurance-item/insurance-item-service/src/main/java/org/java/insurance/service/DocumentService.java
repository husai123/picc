package org.java.insurance.service;

import org.java.insurance.entity.Document;
import org.java.insurance.ov.PageResult;

import java.util.List;

public interface DocumentService {
    List<Document> findById(String ID);

    PageResult<Document> findAll(Integer page, Integer limit);

    void delByid(String pid);

    void updateItem(Document document);

    void saveItem(Document document);

    PageResult<Document> findByInsurance(Integer page, Integer limit, String insurance_id , String Type_id);
}
