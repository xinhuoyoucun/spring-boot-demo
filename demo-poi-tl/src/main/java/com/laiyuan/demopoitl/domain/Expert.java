package com.laiyuan.demopoitl.domain;

import com.deepoove.poi.data.ChartMultiSeriesRenderData;
import com.deepoove.poi.data.ChartSingleSeriesRenderData;
import com.deepoove.poi.data.PictureRenderData;
import lombok.*;

import java.util.List;

/**
 * @author laiyuan
 * @date 2020/12/31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expert {
    private String expertId;
    private String name;
    private String introduction;
    private String unit;
    private String title;
    private String email;
    private String mobile;
    private ChartMultiSeriesRenderData img1;
    private PictureRenderData img2;
    private PictureRenderData img3;
    private ChartSingleSeriesRenderData img4;
    private ChartMultiSeriesRenderData img5;
    private ChartSingleSeriesRenderData img6;
    private ChartSingleSeriesRenderData img7;
    private List<Paper> papers;
    private List<Project> projects;
    private List<Patent> patents;
}
