package defaultconstructor.date;

public class SimpleDateFormatter {
    private CountryCode countryCode;

    public SimpleDateFormatter() {
        this.countryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return String.format("%s-%s-%s", simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
    }
    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if (countryCode == CountryCode.HU) {
            return String.format("%s-%s-%s", simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
        } else if (countryCode == CountryCode.EN) {
            return String.format("%s-%s-%s", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
        } else {
            return String.format("%s-%s-%s", simpleDate.getMonth(), simpleDate.getDay(), simpleDate.getYear());
        }
    }
}