package org.java.insurance.web;

import org.java.insurance.entity.Document;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */


    /**
     *查询单证
     * @param pid
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/document/list
     */
    @GetMapping("/list")
    public ResponseEntity<List<Document>> loadItem(@RequestParam("documents_id") String pid){
        List<Document> list=documentService.findById(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/All")
    public ResponseEntity<PageResult<Document>> loadItem(Integer page, Integer limit){
        System.out.println("1236666");
        PageResult<Document> pageResult=documentService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/FindByInsurance")
    public ResponseEntity<PageResult<Document>> loadDocumentByInsurance(@RequestParam("type_id")String Type_id,@RequestParam("insurance_id")String insurance_id,Integer page, Integer limit){
        System.out.println("666");
        PageResult<Document> pageResult=documentService.findByInsurance(page,limit,insurance_id,Type_id);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    /**
     * 销案删除
     * @param pid
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/document/del？id=xxx
     */
    @DeleteMapping("/del")
    public ResponseEntity<Void>  del(@RequestParam("documents_id") String pid){
        documentService.delByid(pid);

        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Document document){
        documentService.updateItem(document);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/Add")
    public ResponseEntity<Void> saveItem(Document document){
        documentService.saveItem(document);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
