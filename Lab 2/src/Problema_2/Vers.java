package Problema_2;

public class Vers {
        private String vers;

        Vers(String ves)
        {
            this.vers = ves;
        }

        public int Nr_cuvite()
        {
            String[] a=vers.split(" ");
            return a.length;
        }

        // a e i o u
        public  int Nr_vocale()
        {
            int nr=0,i,j;
            String cuvant;
            String[] a=vers.split(" ");

            for(i=0;i<a.length;i++)
            {
                cuvant = a[i];
                for(j=0;j<cuvant.length();j++)
                {
                    char c = cuvant.charAt(j);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    {
                        nr++;
                    }
                }
            }
            return nr;
        }

        public boolean Verficare(String v)
        {
            return vers.endsWith(v);
        }

        public String versMajuscule()
        {
            return vers.toUpperCase();
        }

        public String getVers()
        {
            return vers;
        }
}
