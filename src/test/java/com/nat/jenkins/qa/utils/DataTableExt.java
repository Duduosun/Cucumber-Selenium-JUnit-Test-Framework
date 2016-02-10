package com.nat.jenkins.qa.utils;

import cucumber.api.DataTable;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataTableExt {
    private DataTable dataTable;
    private List<Map<String, String>> maps;
    @Autowired
    private DataStore dataStore;

    public void setTable (DataTable table) {
        this.dataTable = table;
        this.maps = dataTable.asMaps(String.class, String.class);
    }

    /**
     * Returns the number of rows with data
     *
     * @return
     */
    public int getNumberOfRows() {
        return maps.size();
    }

    /**
     * Returns the value for the specified header from the data table
     *
     * @param header
     * @return
     */
    public String getValue(String header) {
        return getValue(0, header);
    }

    /**
     * Returns the value for the specified row and header from the data table
     *
     * @param rowIndex
     * @param header
     */
    public String getValue(int rowIndex, String header) {
        String result = maps.get(rowIndex).get(header);
        // sanitize nulls and blank strings to null
        if (StringUtils.isBlank(result)) {
            result = null;
        }
        // else check for some special flags and substitute their values
        else {
            if (result.equals(BaseConstants.DATATABLE_KEYWORD_EMPTY)) {
                result = "";
            } else if (result.startsWith(BaseConstants.DATATABLE_KEYWORD_RANDOM)) {
                int length = Integer.valueOf(StringUtils.split(result, '_')[1]);
                result = RandomStringUtils.randomAlphanumeric(length);
            }
            else if (result.startsWith(BaseConstants.DATATABLE_KEYWORD_DATA))
            {
                result = dataStore.get(StringUtils.split(result, '_')[1]);
            }
        }
        return result;
    }
}
