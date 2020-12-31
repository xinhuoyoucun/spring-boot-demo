package com.laiyuan.demopoitl.domain;

import com.deepoove.poi.data.TextRenderData;
import lombok.Builder;
import lombok.Data;

/**
 * @author laiyuan
 * @date 2020/12/31
 */
@Data
@Builder
public class Paper {
    private String paperId;
    private TextRenderData name;
    private String authors;
    private String journal;
    private Integer year;
}
