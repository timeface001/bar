package com.fs.util;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @description:阿里云OSS文件工具
 * @author pineF
 * @time:2016年8月27日 上午9:54:12
 */
public class OSSKit {
    /**
     * 阿里云ACCESS_ID
     */
    private static String ACCESS_ID = "LTAIyaw3s6ajUgNN";
    /**
     * 阿里云ACCESS_KEY
     */
    private  static String ACCESS_KEY = "tQrppHDVGfkBYG8ccCFXKrmoInCz9k";
    /**
     * 阿里云OSS_ENDPOINT
     */
    private static String OSS_ENDPOINT = "http://oss-cn-shanghai.aliyuncs.com";

    /**
     * 阿里云BUCKET_NAME  OSS
     */
    private static String BUCKET_NAME = "fmsbb";

    private static  OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);

    public static void main(String[] args) {
        //String bucketName = "demo10";
        String Objectkey = "avatar/profile_big.jpg";

        String uploadFilePath = "C:\\Users\\fengsong\\Desktop\\profile_big.jpg";
        String downloadFilePath = "C:\\Users\\fengsong\\Desktop\\1.jpg";

        // 使用默认的OSS服务器地址创建OSSClient对象,不叫OSS_ENDPOINT代表使用杭州节点，青岛节点要加上不然包异常
        OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);

        //如果你想配置OSSClient的一些细节的参数，可以在构造OSSClient的时候传入ClientConfiguration对象。
        //ClientConfiguration是OSS服务的配置类，可以为客户端配置代理，最大连接数等参数。
        //具体配置看http://aliyun_portal_storage.oss.aliyuncs.com/oss_api/oss_javahtml/OSSClient.html#id2
        //ClientConfiguration conf = new ClientConfiguration();
        //OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY, conf);
        try {
            ensureBucket(client, BUCKET_NAME);
            setBucketPublicReadable(client, BUCKET_NAME);

            //System.out.println("正在上传...");
            //uploadImg(uploadFilePath, "avatar/");
            //uploadFile(client, BUCKET_NAME, Objectkey, uploadFilePath);

            System.out.println("正在下载...");
            downloadFile(client, BUCKET_NAME, Objectkey, downloadFilePath);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            // deleteBucket(client, BUCKET_NAME);
        }
    }

    public static String uploadImg(String filePath,String dir){
        String key=dir+UUID.randomUUID().toString()+"."+ImgKit.getFileByFile(new File(filePath),"jpg");
        try {
            setBucketPublicReadable(client, BUCKET_NAME);

            //System.out.println("正在上传...");
            uploadFile(client, BUCKET_NAME, key, filePath);

           /* System.out.println("正在下载...");
            downloadFile(client, BUCKET_NAME, Objectkey, downloadFilePath);*/
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            // deleteBucket(client, BUCKET_NAME);
        }

        return key;
    }

    public static String uploadImg(InputStream is,String dir){
        String key=dir+UUID.randomUUID().toString()+"."+ImgKit.getFileByFile(is,"jpg");
        try {
            setBucketPublicReadable(client, BUCKET_NAME);

            //System.out.println("正在上传...");
            uploadFile(client, BUCKET_NAME, key, is);

           /* System.out.println("正在下载...");
            downloadFile(client, BUCKET_NAME, Objectkey, downloadFilePath);*/
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            // deleteBucket(client, BUCKET_NAME);
        }

        return key;
    }

    /**
     * 创建Bucket
     *
     * @param client  OSSClient对象
     * @param bucketName  BUCKET名
     * @throws OSSException
     * @throws ClientException
     */
    public static void ensureBucket(OSSClient client, String bucketName)throws OSSException, ClientException{
        try{
            client.createBucket(bucketName);
        }catch(ServiceException e){
            if(!OSSErrorCode.BUCKET_ALREADY_EXISTS.equals(e.getErrorCode())){
                throw e;
            }
        }
    }

    /**
     * 删除一个Bucket和其中的Objects
     *
     * @param client  OSSClient对象
     * @param bucketName  Bucket名
     * @throws OSSException
     * @throws ClientException
     */
    private static void deleteBucket(OSSClient client, String bucketName)throws OSSException, ClientException{
        ObjectListing ObjectListing = client.listObjects(bucketName);
        List<OSSObjectSummary> listDeletes = ObjectListing.getObjectSummaries();
        for(int i = 0; i < listDeletes.size(); i++){
            String objectName = listDeletes.get(i).getKey();
            System.out.println("objectName = " + objectName);
            //如果不为空，先删除bucket下的文件
            client.deleteObject(bucketName, objectName);
        }
        client.deleteBucket(bucketName);
    }

    /**
     * 把Bucket设置成所有人可读
     *
     * @param client  OSSClient对象
     * @param bucketName  Bucket名
     * @throws OSSException
     * @throws ClientException
     */
    private static void setBucketPublicReadable(OSSClient client, String bucketName)throws OSSException, ClientException{
        //创建bucket
        client.createBucket(bucketName);

        //设置bucket的访问权限， public-read-write权限
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
    }

    /**
     * 上传文件
     *
     * @param client  OSSClient对象
     * @param bucketName  Bucket名
     * @param Objectkey  上传到OSS起的名
     * @param filename  本地文件名
     * @throws OSSException
     * @throws ClientException
     * @throws FileNotFoundException
     */
    private static void uploadFile(OSSClient client, String bucketName, String Objectkey, String filename)
            throws OSSException, ClientException, FileNotFoundException{
        File file = new File(filename);


        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(file.length());
        //判断上传类型，多的可根据自己需求来判定
        if (filename.endsWith("xml")) {
            objectMeta.setContentType("text/xml");
        }
        else if (filename.endsWith("jpg")) {
            objectMeta.setContentType("image/jpeg");
        }
        else if (filename.endsWith("png")) {
            objectMeta.setContentType("image/png");
        }

        InputStream input = new FileInputStream(file);
        client.putObject(bucketName, Objectkey, input, objectMeta);
    }

    /**
     * 上传文件
     *
     * @param client  OSSClient对象
     * @param bucketName  Bucket名
     * @param Objectkey  上传到OSS起的名
     * @throws OSSException
     * @throws ClientException
     * @throws FileNotFoundException
     */
    private static void uploadFile(OSSClient client, String bucketName, String Objectkey, InputStream is)
            throws OSSException, ClientException, IOException{

        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(((FileInputStream)is).getChannel().size());
        String filename=ImgKit.getFileByFile(is,"");
        //判断上传类型，多的可根据自己需求来判定
        if (filename.endsWith("xml")) {
            objectMeta.setContentType("text/xml");
        }
        else if (filename.endsWith("jpg")) {
            objectMeta.setContentType("image/jpeg");
        }
        else if (filename.endsWith("png")) {
            objectMeta.setContentType("image/png");
        }

        client.putObject(bucketName, Objectkey, is, objectMeta);
    }

    /**
     *  下载文件
     *
     * @param client  OSSClient对象
     * @param bucketName  Bucket名
     * @param Objectkey  上传到OSS起的名
     * @param filename 文件下载到本地保存的路径
     * @throws OSSException
     * @throws ClientException
     */
    private static void downloadFile(OSSClient client, String bucketName, String Objectkey, String filename)
            throws OSSException, ClientException {
        client.getObject(new GetObjectRequest(bucketName, Objectkey),
                new File(filename));
    }


}