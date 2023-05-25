package com.eve.excel.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.eve.excel.convert.CustomStringStringConverter;
import lombok.Data;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
//@ExcelIgnoreUnannotated 加了@ExcelIgnoreUnannotated注解以后，不加ExcelProperty注解的字段就不会参与读写。
//@ColumnWidth(15) 注解作用于类上将会设置全部单元格的宽度为15,注解作用于字段上会设置字段所对应的Excel列的宽度为15
//@ContentRowHeight(15) 设置行高。它的值是Excel文件中的行高。值为-1时代表自动设置行高。
//@ContentFontStyle 用于设置单元格内容字体格式的注解  都可以作用于类或者字段上，注解参数也完全一致
//@HeadFontStyle  设置标题的字体样式。都可以作用于类或者字段上，注解参数也完全一致
//
public class ExDataExport {

    @ExcelProperty("行号")
    private Integer id;

    @ExcelProperty(value = "名字",converter = CustomStringStringConverter.class)
    private String name;

    @ExcelProperty("公司编码")
    private String companyId;

    /**
     * 颜色值可以在IndexedColors.RED这个枚举中找到。使用代码可以直接IndexedColors.RED.getIndex()设置颜色值，注解的话，只能直接写数字
     * italic 是否斜体
     */
    @ExcelProperty("公司名称")
    @ContentFontStyle(fontName = "方正舒体",color = 10,italic = BooleanEnum.TRUE)
    private String companyName;

    @ExcelProperty("创建日期")
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private LocalDateTime createTime;

    @ExcelProperty("金额")
    @NumberFormat("0.00")  // 格式 参考 DecimalFormat用法， DecimalFormatTest
    private BigDecimal amount;

    // 忽略这个字段，不写入Excel当中
    @ExcelIgnore
    private String ignore;
}
