package com.wh.gulimall.product;



import com.aliyun.oss.*;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wh.gulimall.product.entity.BrandEntity;
import com.wh.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {


    @Autowired
    BrandService brandService;

    @Resource
    OSSClient ossClient;

    @Test
    public void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();

//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功。。。。。");

//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("华为");
//        brandService.updateById(brandEntity);
//        System.out.println("修改成功。。。");

//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", "1"));
//        list.forEach((item)->{
//            System.out.println(item);
        }

        @Test
        public void testUpload(){

//            // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//            String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
//            // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//            String accessKeyId ="LTAI5tKLGh9F8yWcvKak314g";
//            String accessKeySecret ="Wc9KOHDEelkZM4VuDho37TGNLeRqe1";
            // 填写Bucket名称，例如examplebucket。
            String bucketName = "w-gulimall";
            // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
            String objectName = "ab.txt";
            // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
            // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
            String filePath= "E:\\IdeaWork\\GuLimall\\gulimall-product\\src\\test\\resources\\abc.txt";

//            // 创建OSSClient实例。
//            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            try {
                // 创建PutObjectRequest对象。
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new File(filePath));
                // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
                // ObjectMetadata metadata = new ObjectMetadata();
                // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
                // metadata.setObjectAcl(CannedAccessControlList.Private);
                // putObjectRequest.setMetadata(metadata);

                // 上传文件。
                ossClient.putObject(putObjectRequest);
            } catch (OSSException oe) {
                System.out.println("Caught an OSSException, which means your request made it to OSS, "
                        + "but was rejected with an error response for some reason.");
                System.out.println("Error Message:" + oe.getErrorMessage());
                System.out.println("Error Code:" + oe.getErrorCode());
                System.out.println("Request ID:" + oe.getRequestId());
                System.out.println("Host ID:" + oe.getHostId());
            } catch (ClientException ce) {
                System.out.println("Caught an ClientException, which means the client encountered "
                        + "a serious internal problem while trying to communicate with OSS, "
                        + "such as not being able to access the network.");
                System.out.println("Error Message:" + ce.getMessage());
            } finally {
                if (ossClient != null) {
                    ossClient.shutdown();
                }
            }
        }

    }

