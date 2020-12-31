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
public class Patent {
    private String PatentId;
    private TextRenderData name;
    private String type;
    private String unit;
    private String authors;
}
