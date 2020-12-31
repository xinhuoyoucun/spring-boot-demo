package com.laiyuan.demopoitl;

import cn.hutool.core.date.DateUtil;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import com.deepoove.poi.data.*;
import com.laiyuan.demopoitl.domain.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.util.*;

@SpringBootTest
@Slf4j
class DemoPoiTlApplicationTests {

    @Test
    void contextLoads() {

    }

    public static Demand getDemand() {
        Demand demand = Demand.builder()
            .code("123123")
            .title("需求标题需求标题需求标题需求标题").content("需求描述需求描述需求描述需求描述需求描述").keywords("数据挖掘,机器学习,java")
            .subjects("电子信息").requirement(null).source("杭州电子科技大学")
            .budget(1000).coos("项目合作").financing(true).time(DateUtil.date())
            .build();
        return demand;
    }

    public static List<Paper> getPapers(String expertId){
        List<Paper> list=new ArrayList<>();
        list.add(Paper.builder()
            .name(Texts.of("website").link("https://www.itech4u.cn/paperDetail/"+"1111").create())
            .paperId("1").authors("11,11,11").journal("aasdas").year(111)
            .build());
        return list;
    }

    public static List<Patent> getPatents(String expertId){
        List<Patent> list=new ArrayList<>();
        list.add(Patent.builder()
            .name(Texts.of("website").link("https://www.itech4u.cn/patentDetail/"+"1111").create())
            .authors("aaa,aaa").PatentId("1").type("aaa").unit("aaa")
            .build());
        return list;
    }

    public static List<Project> getProjects(String expertId){
        List<Project> list=new ArrayList<>();
        list.add(Project.builder()
            .name(Texts.of("website").link("https://www.itech4u.cn/projectDetail/"+"1111").create())
            .authors("aa,aa").projectId("1").type("aa").unit("aaa")
            .build());
        return list;
    }

    public static List<Expert> getExpertList() {
        List<Expert> experts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Expert expert = Expert.builder().expertId("aaaaa")
                .name("小王").title("教授").unit("杭州电子科技大学").email("xxxx@aa.com").mobile("18988989891")
                .papers(getPapers("aaaaa")).patents(getPatents("aaaaa")).projects(getProjects("aaaaa"))
                .img1(Charts
                    .ofMultiSeries("专业能力分析图", new String[] { "论文", "项目","专利","活跃度","实践度" })
                    .addSeries("专业能力", new Double[] { 15.0,11.0,13.0,22.0,35.0 })
                    .create())
                .img2(Pictures.ofUrl("http://deepoove.com/images/icecream.png", PictureType.PNG)
                    .size(100, 100).create())
                .img3(Pictures.ofUrl("http://deepoove.com/images/icecream.png", PictureType.PNG)
                    .size(100, 100).create())
                .img4(Charts
                    .ofSingleSeries("产出总量", new String[] { "aaa", "bbb" })
                    .series("期刊", new Integer[] { 9826675, 9596961 })
                    .create())
                .img5(Charts
                    .ofMultiSeries("年度分布图", new String[] { "中文", "English" })
                    .addSeries("countries", new Double[] { 15.0, 6.0 })
                    .addSeries("speakers", new Double[] { 223.0, 119.0 })
                    .create())
                .img6(Charts
                    .ofSingleSeries("论文成果期刊分布图", new String[] { "aaa", "bbb" })
                    .series("期刊", new Integer[] { 9826675, 9596961 })
                    .create())
                .img7(Charts
                    .ofSingleSeries("项目成果分布图", new String[] { "横向项目", "面上项目" })
                    .series("类型", new Integer[] { 1, 2 })
                    .create())
                .build();
            experts.add(expert);
        }
        return experts;
    }

    public static RowRenderData[] getExpertTable() {
        List<Expert> experts = getExpertList();

        RowRenderData row0 = Rows.of("姓名", "单位", "职称", "联系方式").textColor("FFFFFF")
            .bgColor("4472C4").center().create();

        RowRenderData[] rowRenderData = new RowRenderData[experts.size() + 1];
        rowRenderData[0] = row0;
        for(int i = 0;i<experts.size();i++){
            Expert expert=experts.get(i);
            rowRenderData[i+1] = Rows.create(expert.getName(), expert.getUnit(), expert.getTitle(), expert.getMobile());
        }

        return rowRenderData;
    }

    public static List<Expert> getExperts(){
        List<Expert> experts = getExpertList();
        return experts;
    }

    @Test
    @SneakyThrows
    void createWord() {
        Map<String, Object> report = new HashMap<>(4);

        List<Expert> experts = new ArrayList<>();

        report.put("demand", getDemand());
        report.put("expertTable", Tables.create(getExpertTable()));
        report.put("experts", getExperts());
        report.put("zonghepingjia", "暂无评价");


        ConfigureBuilder builder = Configure.builder().useSpringEL();
        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/temp.docx",builder.build()).render(report);
        template.writeAndClose(new FileOutputStream("src/test/resources/output.docx"));
    }
}
