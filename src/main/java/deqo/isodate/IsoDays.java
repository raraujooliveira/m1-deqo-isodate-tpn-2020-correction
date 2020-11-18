package deqo.isodate;

/**
 * Classe représentant un numéro de jour dans l'année,
 * c'est-à-dire, le nombre de jours écoulés depuis le 1er janvier de l'année,
 * en prennant en compte si l'année est bissextile ou pas.
 *
 * Le parsing et le pretty-printing suivent le standard ISO 8601 YYYY-DDD.
 *
 * Pretty-printing permet d'afficher dans un format user-friendly.
 * Par exemple, la date "5/1/19" affichée en "pretty-printing" selon le standard ISO 8601 YYYY-DDD
 * serait affichée comme ceci: "2019-005".
 *
 * Un autre exemple: la date "5/2/19" serait affichée comme ceci : "2019-036"
 *
 */
public class IsoDays {

    /**
     * Année.
     */
    private int year;

    /**
     * Numéro du jour dans l'année (nombre supérieur ou égal à 1).
     */
    private int days;

    public static final int Y_SIZE = 4;

    public IsoDays(int year, int days) {
        this.year = year;
        this.days = days;
    }

    /**
     * Construit un jour de l'année.
     *
     * @param date la date au format YYYY-DDD
     *
     * Une exception est levée si la date passée en paramètre n'a pas ce format
     * (le format est défini ici par une expression régulière)
     */
    public IsoDays(String date) throws IsoDateException {
        if (!date.matches("^[0-9]{4}-[0-9]{3}$")) {
            throw new IsoDateException();
        }
        year = Integer.parseInt(date.substring(0, Y_SIZE));
        days = Integer.parseInt(date.substring(Y_SIZE + 1));
    }

    /**
     * Renvoie le jour en ISO 8601.
     *
     * @return chaîne au format YYYY-DDD
     *
     * La méthode "format" de la classe java "String" permet de
     * formatter une chaine de caracter selon le specificateur de format défini.
     * Ex: "%d" pour un entier
     */
    @Override
    public String toString() {
        return String.format("%04d-%03d", year, days);
    }
}
