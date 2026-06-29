import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    Map<Integer,String> dialCodes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return dialCodes;
    }

    public void setDialingCode(Integer code, String country) {
        dialCodes.put(code,country);
    }

    public String getCountry(Integer code) {
        return dialCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!(dialCodes.containsKey(code))) {
            if(!(dialCodes.containsValue(country))) {
                dialCodes.put(code, country);
            }
        }
    }

    public Integer findDialingCode(String country) {
        int dialCode = 0;
        for (Map.Entry<Integer,String> entry: dialCodes.entrySet()) {
            if (entry.getValue().equals(country)) {
                dialCode =  entry.getKey();
                break;
            }
        }
        return dialCode==0 ? null : dialCode;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        for (Map.Entry<Integer,String> entry: dialCodes.entrySet()) {
            if (entry.getValue().equals(country)) {
                dialCodes.put(code,country);
                dialCodes.remove(entry.getKey());
            }
        }
    }
}
