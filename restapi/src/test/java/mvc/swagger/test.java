package mvc.swagger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sutpc.iot.monitor.data.model.IotDataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    private static final Logger LOG = LoggerFactory.getLogger(test.class);

    public static void main(String[] args) {

        String value = "{\"static\":-0.01,\"sampling_time\":\"2021-01-15 13:21:19.000\",\"equip_id\":1347431265709764609,\"equip_type_id\":1345929670811500545,\"monitor_id\":1347431930121072642,\"manager_id\":1345928580510564353}";

        JSONObject objIot = (JSONObject) JSON.parse(value);
        String str = value.substring(value.indexOf("{") + 1, value.lastIndexOf("}"));
        String[] arr = str.split(",");
        System.out.println(str.split(","));

        objIot.containsKey("static");
        String dataWithYype = arr[0];
        String data_type = dataWithYype.split(":")[0].replace("\"", "");
        String sensor_data = dataWithYype.split(":")[1];
        IotDataVo iotData = new IotDataVo(
                objIot.getDate("sampling_time")
                , objIot.getBigDecimal("equip_id")
                , objIot.getBigDecimal("equip_type_id")
                , objIot.getBigDecimal("monitor_id")
                , objIot.getBigDecimal("manager_id")
                , sensor_data, data_type);

        LOG.info(String.format("iot data array [%s].[%s]", arr, str));
    }


    private static Date str2Date(String strDate) {
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        try {
            date = format.parse(strDate);
        } catch (ParseException pexcp) {
            LOG.error(String.format("[ParseException] @ converting date [%s]. exception message [%s]", strDate, pexcp));
        }
        return date;

    }

    private static BigDecimal str2Bigdecimal(String strNum) {
        return new BigDecimal(strNum);
    }


}
