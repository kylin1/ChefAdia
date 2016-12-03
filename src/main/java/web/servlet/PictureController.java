package web.servlet;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


@Controller
@RequestMapping("/file")
public class PictureController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    private String fildUpload(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "password", required = false) String password,
                              @RequestParam(value = "file", required = false) MultipartFile file,
                              HttpServletRequest request) throws Exception {
        //获得物理路径webapp所在路径
        String pathRoot = "/data/wwwroot/default/images/";
//        String pathRoot = "/Users/kylin/Desktop/";
        System.out.println(name+' '+password);
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            String imagePath = uuid + name + "." + imageName;
            String newFile = pathRoot + imagePath;
            System.out.println("newFile=" + newFile);
            file.transferTo(new File(newFile));
            request.setAttribute("imagesPath", newFile);
        }

        return "showPicture";
    }

    //因为我的JSP在WEB-INF目录下面，浏览器无法直接访问
    @RequestMapping(value = "/forward")
    private String forward() {
        return "uploadPicture";
    }
}