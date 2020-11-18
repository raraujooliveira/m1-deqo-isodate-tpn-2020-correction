package deqo.isodate;

/**
 * Classe représentant un jour de l'année.
 *
 * Le parsing et le pretty-printing suivent le standard ISO 8601 YYYY-MM-DD
 *
 * Pretty-printing permet d'afficher dans un format user-friendly.
 * Par exemple, la date "1/5/19" affichée en "pretty-printing" selon le
 * standard ISO 8601 YYYY-MM-DD serait affichée comme ceci: "2019-05-01"
 *
 */
public class IsoDate {

    /**
     * Année.
     */
    private int year;

    /**
     * Mois (nombre entre 1 et 12).
     */
    private int month;

    /**
     * Numéro du jour (nombre entre 1 et 31).
     */
    private int day;

    public static final int Y_SIZE = 4;
    public static final int M_SIZE = 2;

    public IsoDate(final int yearP, final int monthP, final int dayP) {
        this.year = yearP;
        this.month = monthP;
        this.day = dayP;
    }

    /**
     * Construit un jour de l'année.
     *
     * @param date la date au format YYYY-MM-DD
     *
     * Une exception est levée si la date passée en paramètre n'a pas ce format
     * (le format est défini ici par une expression régulière)
     */
    public IsoDate(String date) throws IsoDateException {
        if (!date.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
            throw new IsoDateException();
        }
        year = Integer.parseInt(date.substring(0, Y_SIZE));
        month = Integer.parseInt(date.substring(Y_SIZE + 1,
                                                Y_SIZE + 1 + M_SIZE));
        day = Integer.parseInt(date.substring(Y_SIZE + 1 + M_SIZE + 1));
    }

    /**
     * Renvoie le jour en ISO 8601.
     *
     * @return chaîne au format YYYY-MM-DD
     *
     * La méthode "format" de la classe java "String" permet de
     * formatter une chaine de caracter selon le specificateur de format défini.
     * Ex: "%d" pour un entier
     */
    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }

    /**
     * Calcule le nombre de jours écoulés depuis le 1er janvier.
     *
     * @return numéro du jour dans l'année depuis le 1er janvier
     * Exemples: si year=2019, month=1, day=5 (pour "2019-01-05"), renvoie 5
     * si year=2019, month=2, day=5 (pour "2019-02-05"), renvoie 36
     */
    private int days_of_year() {
        final int[] months = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // a leap year = a bissextile year, où fevrier a 29 jours
        final int leapFeb = 29;
        // fevrier a 28 jours
        final int noLeapFeb = 28;
        boolean leap = new Year(year).isLeapYear();
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += (i != 2 ? months[i - 1] : (leap ? leapFeb : noLeapFeb));
        }
        return day + days;
    }

    /**
     * Construit un objet IsoDays à partir de l'objet IsoDate courant ("this").
     *
     * @return objet IsoDays représentant la même date
     * Exemples:
     * si year=2019, month=1, day=5, (pour "2019-01-05"), renvoie "2019-005"
     * si year=2019, month=2, day=5 (pour "2019-02-05"), renvoie "2019-036"
     */
    public IsoDays toIsoDays() {
        return new IsoDays(year, days_of_year());
    }
}
