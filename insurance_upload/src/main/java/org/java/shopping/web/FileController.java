package org.java.shopping.web;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.java.shopping.vo.FileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileController {

    @Value("${file.upload}")
    private String path;//该变量，用于获得文件上传的路径

    @RequestMapping("/img")
    public ResponseEntity<FileVO> up(MultipartFile file) throws IOException {

        System.out.println("###############>>>>>>>>>>>>>");
        //获得文件的信息，先把上传的文件，保存在本地服务器

        //获得文件名 -----a.jpg
        String fname = file.getOriginalFilename();

        //获得文件的扩展名----jpg
        String type = fname.substring(fname.lastIndexOf(".")+1);

        //产生一个新的文件名，目的，防止文件出现重名
        String newFileName = UUID.randomUUID()+"."+type;

        //在指定路径下，产生一个指定名称的新文件----------------空文件，没有数据
        File newFile = new File(path,newFileName);

        //将上传文件中的数据，写入到新文件中
        file.transferTo(newFile);

        /*************************准备将本地文件，写入到fastdfs**********************************************/


        try {
            //加载属性文件  fastdfs-client.properties
            ClientGlobal.initByProperties("fastdfs-client.properties");


            //创建tracker(跟踪器，用于调用storage)
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();


            //创建存储器
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            //指定存储的数据的相关信息（元数据:文件本身的原始信息 ）
            NameValuePair[] metaList = new NameValuePair[1];

            //指定的文件名称
            metaList[0] = new NameValuePair("fileName", newFileName);

            //指定，要上传文件，以及文件的扩展名--------同时上传
            String fileId = client.upload_file1(newFile.getAbsolutePath(), type, metaList);

            //上传成功后，会返回当前文件存在fastdfs中的位置 ：文件位置：fileId

            System.out.println("upload success. file id is: " + fileId);

            //返回的地址是: group1/M00/02/44/XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.JPG
            //仅仅这个地址，无法访问fastdfs，还需要加上fastdfs的主机ip
            //http://192.168.112.128/group1/M00/02/44/XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.JPG
            //一般不会通过ip访问fastdfs主机，而是通过域名访问
            // img.shopping.com指向 192.168.112.128这台主机


            //如果要网址访问该文件形式是: http://ip地址/fileId

            //创建FileVO对象，封装返回结果
            FileVO fileVO = new FileVO();
            fileVO.setCode(1);//上传成功
            fileVO.setMsg("上传成功");
            fileVO.setData("http://img.shopping.com/"+fileId);

            System.out.println("文件的位置是:"+fileVO.getData());
            return ResponseEntity.status(HttpStatus.OK).body(fileVO);

        } catch (Exception ex) {
            //创建FileVO对象，封装返回结果
            FileVO fileVO = new FileVO();
            fileVO.setCode(0);//上传失败
            fileVO.setMsg("上传失败");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fileVO);
        }
    }




    /**
     * 文件上传:  此时访问路径: http://xxxxx.shopping.com/api/网关的前缀/upload/img
     * @param file  上传的文件
     * @return
     */
    /*
    @RequestMapping("/img")
    public ResponseEntity<FileVO> upload1(MultipartFile file){

        //获得上传的文件名称
        String fname = file.getOriginalFilename();

        //在保存上传文件的路径下，产生一个指定的新文件(空文件)
        File newFile = new File(path,fname);

        //要判断，当前路径是否存在，不存在就创建
        if(!newFile.getParentFile().exists()){
            //目录不存在
            newFile.getParentFile().mkdirs();//创建目录
        }
        //封装FileVo对象，返回上传的结果
        FileVO fileVO = new FileVO();

        try {

            file.transferTo(newFile);//将上传文件数据写入到新文件中
            fileVO.setCode(1);//上传成功
            fileVO.setMsg("上传成功");
            fileVO.setData(newFile.getAbsolutePath());//获得上传的路径

            return ResponseEntity.status(HttpStatus.OK).body(fileVO);
        } catch (IOException e) {

            e.printStackTrace();;
            fileVO.setCode(0);//上传失败
            fileVO.setMsg("上传失败");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fileVO);
        }


    }
    */
}
