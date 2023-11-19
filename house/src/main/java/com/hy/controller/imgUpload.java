package com.hy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.mapper.PostMapper;
import com.hy.pojo.Post;
import com.hy.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/pic")
public class imgUpload {
@Autowired
private PostMapper postMapper;


    @PostMapping("/upload1")
    public String saveVue(@RequestParam("file") MultipartFile file) throws IOException {
        //拿到具体文件 file

        if (file.isEmpty()) {
            return null;
        }
        String OriginalFilename=file.getOriginalFilename();
        String fileName=System.currentTimeMillis()+"."+OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);

        String path="D:\\vue\\vue-1\\src\\pic\\";
        File dest=new File(path+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try{
            file.transferTo(dest);
            QueryWrapper<Post> wrapper=new QueryWrapper<>();
            wrapper.select("max(postid) as postid");

           Integer x= postMapper.selectOne(wrapper).getPostid();
           wrapper.eq("postid",x);
           Post post=new Post();
           post.setImgUrl("src\\pic\\"+fileName);
            post.setPostSummary("src\\pic\\"+fileName);
            post.setPostThumbnail("src\\pic\\"+fileName);

           postMapper.update(post,wrapper);
            return "src\\pic\\"+fileName;
        }catch (IOException e){e.printStackTrace();
            return null;
        }
    }



    @PostMapping("/upload")
    public String uploadPic(@RequestParam MultipartFile file)throws FileNotFoundException{

if (file.isEmpty()) {
    return null;
}
String OriginalFilename=file.getOriginalFilename();
String fileName=System.currentTimeMillis()+"."+OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);

String path="D:\\vue\\vue-1\\src\\pic\\";
File dest=new File(path+fileName);
if(!dest.getParentFile().exists()){
    dest.getParentFile().mkdirs();
}

try{
    file.transferTo(dest);

    return fileName;
}catch (IOException e){e.printStackTrace();
return null;
}
}

}
