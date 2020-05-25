import java.util.Scanner

enum class Currency {
    EURO,
    CFA_FRANC,
    EASTERN_CARIBBEAN_DOLLAR,
    CANADIAN_DOLLAR,
    BRAZILIAN_REAL,
    AUSTRALIAN_DOLLAR,
    NULL
}

data class Country(
        var name: String,
        var currency: Currency
)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
//    Germany France
    val inputString = input.nextLine()
    val str = "([A-Z])\\w+".toRegex().findAll(inputString)

    val name1 = str.elementAt(0).value
    val name2 = str.elementAt(1).value

    val countries = arrayOfCountrys()

    var country1 = Country("Country Null 1", Currency.NULL)
    var country2 = Country("Country Null 2", Currency.NULL)

    for (item in countries) {
        if (item.name == name1) {
            country1 = item
        } else if (item.name == name2) {
            country2 = item
        }
    }

    println(country1.currency == country2.currency)

}

private fun arrayOfCountrys(): Array<Country> {
    return arrayOf(
            Country("Germany", Currency.EURO),
            Country("Mali", Currency.CFA_FRANC),
            Country("Dominica", Currency.EASTERN_CARIBBEAN_DOLLAR),
            Country("Canada", Currency.CANADIAN_DOLLAR),
            Country("Spain", Currency.EURO),
            Country("Australia", Currency.AUSTRALIAN_DOLLAR),
            Country("Brazil", Currency.BRAZILIAN_REAL),
            Country("Senegal", Currency.CFA_FRANC),
            Country("France", Currency.EURO),
            Country("Grenada", Currency.EASTERN_CARIBBEAN_DOLLAR),
            Country("Kiribati", Currency.AUSTRALIAN_DOLLAR)
    )
}