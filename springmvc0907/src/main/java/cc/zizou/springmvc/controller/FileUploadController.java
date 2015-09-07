package cc.zizou.springmvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/cc")
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        if (multipartFile != null) {
            // multipartFile.getOriginalFilename() 获取文件的原始名称
            multipartFile.transferTo(new File("G:\\abc\\" + multipartFile.getOriginalFilename()));
        }
        return "redirect:/html/success.html";
    }
}
