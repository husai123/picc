package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Data_dictionary;
import org.java.insurance.entity.Document;
import org.java.insurance.entity.DocumentView;
import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.DocumentMapper;
import org.java.insurance.mapper.Type_of_insuranceMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private Type_of_insuranceMapper type_of_insuranceMapper;
    @Autowired
    private Type_of_insuranceImpl type_of_insuranceImpl;
    @Autowired
    private Data_dictionaryServiceImpl data_dictionaryServiceImpl;

    /**
     * 查询id
     * @param pid
     * @return
     */
    @Override
    public List<Document> findById(String pid) {

        //创建一个Category对象，用于封装查询条件
        Document document = new Document();
        document.setDocuments_id(pid);//设置要查询的id

        //查询
        List<Document> list = documentMapper.select(document);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;

    }
    @Override
    public PageResult<Document> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);

        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(documentMapper.selectAll());

        //获得分页查询的结果
        List list=info.getList();
        System.out.println(list);
        List<DocumentView> list2 = new ArrayList<>();
        Iterator<Document> iterator = list.iterator();
        while (iterator.hasNext()) {
            Document document = (Document) iterator.next();
            String str = document.getInsurance_id();
            System.out.println(str);
            Integer type_id = Integer.valueOf(document.getType_id());
            List<Data_dictionary> data_dictionaries = data_dictionaryServiceImpl.findById(type_id);
            Data_dictionary data_dictionary = data_dictionaries.get(0);
            System.out.println(data_dictionary.getShow_value());
            List<Type_of_insurance> type_of_insurances = type_of_insuranceImpl.findById2(str);
            Type_of_insurance type = type_of_insurances.get(0);
            System.out.println(type.getInsurance_name());

            DocumentView documentView = new DocumentView();
            documentView.setDocuments_id(document.getDocuments_id());
            documentView.setDocuments_name(document.getDocuments_name());
            documentView.setInsurance_id(document.getInsurance_id());
            documentView.setInsurance_name(type.getInsurance_name());
            documentView.setType_id(String.valueOf(data_dictionary.getId()));
            documentView.setType_name(data_dictionary.getShow_value());
            documentView.setIs_requried(document.getIs_requried());
            if(document.getIs_requried().equals("1")){
                documentView.setIs_requriedView("是");
            }else {
                documentView.setIs_requriedView("否");
            }
            iterator.remove();
            list2.add(documentView);
        }

        Iterator<DocumentView> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            DocumentView documentView = (DocumentView) iterator2.next();
            list.add(documentView);
        }

        //如果查询结果不为空，则封装成pageResult
        PageResult<Document> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数
        return pageResult;
    }

    @Override
    public void delByid(String pid) {
        int count = documentMapper.deleteByPrimaryKey(pid);//删除数据返回受影响的行数
        if (count==0){
            //删除失败
            throw new InsuranceException(InsuranceEnum.BRAND_REMOVE_ERROR);
        }
    }

    @Override
    public void updateItem(Document document) {
        int count = documentMapper.updateByPrimaryKey(document);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }

    @Override
    public void saveItem(Document document) {
        UUID uuid = UUID.randomUUID();
        document.setDocuments_id(String.valueOf(uuid));
        int count = documentMapper.insert(document);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }
}
