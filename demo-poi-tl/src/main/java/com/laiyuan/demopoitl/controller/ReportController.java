package com.laiyuan.demopoitl.controller;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.util.PoitlIOUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * @author laiyuan
 * @date 2020/12/30
 */
@RestController
@Slf4j
public class ReportController {

    @SneakyThrows
    @GetMapping("/get")
    public void get(HttpServletResponse response) {
        XWPFTemplate template = XWPFTemplate.compile(new ClassPathResource("templates/template.docx").getFile()).render(
            new HashMap<String, Object>(1) {{
                put("title", "Hi, poi-tl Word模板引擎");
            }}
        );




        //输出
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=\"" + "out_template.docx" + "\"");

        try {
            OutputStream out = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            template.write(bos);
            out.flush();
            bos.flush();
            PoitlIOUtils.closeQuietlyMulti(template, bos, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
