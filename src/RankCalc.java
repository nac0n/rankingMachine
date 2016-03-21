
public class RankCalc
{
    //Alla funktioner som bidrar till att räkna ut ELO algorithmen

    public static double transformedRating(double ratingPrev)
    {
        double transformedRating;
        transformedRating = Math.pow(10,((ratingPrev)/400));
        return transformedRating;
    }
    public static double expectedScore(double ratingPrev, double otherRating)
    {
        double expectedScore = transformedRating(ratingPrev) / (transformedRating(ratingPrev)
                + transformedRating(otherRating));
        return expectedScore;
    }

    public static double actualScoreMethod(Boolean hasWon, Boolean wasTie)
    {
        double x;
        if (hasWon == true)
        {
            x = 1.0;
        }
        else
        {
            x = 0.0;
        }
        if (wasTie == true)
        {
            x = 0.5;
        }

        return x;
    }

    public static int kFactor (int doublePrevRank, int playergamesINT)
    {
        int k ;

        if (doublePrevRank > 2400 && playergamesINT >=15)
        {
            k = 5;
        }
        else if (doublePrevRank < 2400 && doublePrevRank >= 2100  && playergamesINT >=15)
        {
            k = 10;
        }
        else if (doublePrevRank < 2100 && doublePrevRank >= 1700  && playergamesINT >=15)
        {
            k = 15;
        }
        else if (doublePrevRank < 1700 && doublePrevRank >= 1600  && playergamesINT >=15)
        {
            k = 20;
        }
        else if (playergamesINT >= 15)
        {
            k = 25;
        }
        else {
            k = 35;
        }

        System.out.println(k);
        return k;
    }


}
