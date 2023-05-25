package com.eve.excel.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

public class CustomStringStringConverter implements Converter<String> {

    // 所支持的java类型
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    // 所支持的Excel枚举类型
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     * @param context	上下文对象  可以获取当前读的单元格的文字内容
     * @return			格式化后的值
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        return "自定义：" + context.getReadCellData().getStringValue();
    }

    /**
     * 这里是写的时候会调用 通常情况可以不用管
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        return new WriteCellData<>(context.getValue());
    }
}
