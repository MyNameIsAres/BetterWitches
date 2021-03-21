package org.geminicraft.betterwitch;

import lombok.Getter;
import lombok.Setter;
import org.mineacademy.fo.Common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParamsFileHandler {

    String key;

    @Setter
    @Getter
    private Map<String, String> paramMap = new ConcurrentHashMap<>();

    public ParamsFileHandler(String params) {

        if (!params.startsWith("${") && !params.endsWith("}")) {
            Common.log("*ERROR* Incorrect parameter types");
        }

        this.key = params.substring(0, params.indexOf("{"));
        int startPosition = params.indexOf("{") + 1;
        int lastPosition = params.lastIndexOf("}");


        // This can bring over the params result to another method possibly
        params = params.substring(startPosition, lastPosition);

        String[] stringItems = params.split(";");

        for (String item : stringItems) {
            String key = item.substring(0, item.indexOf("=")).trim().toLowerCase();
            String value = item.substring(item.indexOf("=") + 1).trim();

            paramMap.put(key, value);
        }

    }

    public String getKeyString(String input) {

        if (paramMap.containsKey(input)) {
            return paramMap.get(input);
        }

        return null;
    }

    public String getKeyString(String input, String defaultValue) {

        if (paramMap.containsKey(input)) {
            return paramMap.get(input);
        }

        return defaultValue;
    }

    public Integer getKeyInteger(String input, int defaultValue) {
        if (paramMap.containsKey(input)) {
            try {
                return Integer.parseInt(paramMap.get(input));
            } catch (Exception exception) {
                Common.log("ERROR: Couldn't load integer key. Resulting to default value.");
            }
        }

        return defaultValue;
    }

    public Double getKeyDouble(String input, double defaultValue) {
        if (paramMap.containsKey(input)) {
            try {
                return Double.parseDouble(paramMap.get(input));
            } catch (Exception exception) {
                Common.log("ERROR: Couldn't load integer key. Resulting to default value.");
            }
        }

        return defaultValue;
    }

    public Float getKeyFloat(String input, float defaultValue) {
        if (paramMap.containsKey(input)) {
            try {
                return Float.parseFloat(paramMap.get(input));
            } catch (Exception exception) {
                Common.log("ERROR: Couldn't load integer key. Resulting to default value.");
            }
        }

        return defaultValue;
    }

}
