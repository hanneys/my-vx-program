package com.eve.excel.config;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自适应列宽
 */
public class CustomCellWriteWidthHandler extends AbstractColumnWidthStyleStrategy {

    //固定最大宽度
    Integer fixedWidth;

    //固定宽度
    private Map<Integer, Map<Integer, Integer>> sheetCache;

    public CustomCellWriteWidthHandler() {
        this.sheetCache = new HashMap<>();
    }

    public CustomCellWriteWidthHandler(Integer fixedWidth) {
        this.fixedWidth = fixedWidth;
        this.sheetCache = new HashMap<>();
    }

    @Override
    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer integer, Boolean isHead) {
        if(fixedWidth!=null){
            int columnWidth = this.fixedWidth;
            if (columnWidth >= 0) {
                if (columnWidth > 40) {
                    columnWidth = 40;
                }
            }
            writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), columnWidth * 280);
        }else {
            boolean needSetWidth = isHead || !CollectionUtils.isEmpty(cellDataList);
            if (needSetWidth) {
                Map<Integer, Integer> maxColumnWidthMap = sheetCache.computeIfAbsent(writeSheetHolder.getSheetNo(), k -> new HashMap<>());

                Integer columnWidth = this.dataLength(cellDataList, cell, isHead);
                if (columnWidth >= 0) {
                    if (columnWidth > 40) {
                        columnWidth = 40;
                    }

                    Integer maxColumnWidth = maxColumnWidthMap.get(cell.getColumnIndex());
                    if (maxColumnWidth == null || columnWidth > maxColumnWidth) {
                        maxColumnWidthMap.put(cell.getColumnIndex(), columnWidth);
                        writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), columnWidth * 280);
                    }
                }
            }
        }
    }

    private Integer dataLength(List<WriteCellData<?>> cellDataList, Cell cell, Boolean isHead) {
        if (isHead) {
            return cell.getStringCellValue().getBytes().length;
        } else {
            WriteCellData<?> cellData = cellDataList.get(0);
            CellDataTypeEnum type = cellData.getType();
            if (type == null) {
                return -1;
            } else {
                switch (type) {
                    case STRING:
                        return cellData.getStringValue().getBytes().length;
                    case BOOLEAN:
                        return cellData.getBooleanValue().toString().getBytes().length;
                    case NUMBER:
                        return cellData.getNumberValue().toString().getBytes().length;
                    default:
                        return -1;
                }
            }
        }
    }
}
