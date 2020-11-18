package deqo.isodate;

/**.
 * Classe représentant une année
 */
public class Year {

    /**.
     * Année
     */
    private int year;

    /**.
     * Récupère l'année
     * @return année
     */
    public int getYear() {
        return year;
    }

    public Year(final int yearP) {
        this.year = yearP;
    }

    /**.
     * Calcule si l'année est bissextile
     *
     * @return true s'il s'agit d'une année bissextile
     * (qui comporte 366 jours au lieu de 365)
     */
    public boolean isLeapYear() {
        return ((year % (2 * 2) == 0) && (year % (50 + 50) != 0))
               || year % (200 + 200) == 0;
    }
}
