
class TribeInfo {

    String name;
    int fierceness;
    String planet;

    public TribeInfo (String name, int fierceness, String planet)
    {
        this.name = name;
        this.fierceness = fierceness;
        this.planet = planet;
    }

    public String toString ()
    {
        return "Tribe: " + name + " from planet " + planet + " rating=" + fierceness;
    }
    

} //end-TribeInfo


public class HashMapExample {

    public static void main (String[] argv)
    {
        // Create an instance with 10 buckets.
        OurHashMap map = new OurHashMap (10);

        // Put some key-value pairs inside.
        TribeInfo info = new TribeInfo ("Ewok", 3, "Endor");
        KeyValuePair kvp = new KeyValuePair ("Ewok", info);
        map.add (kvp);

        info = new TribeInfo ("Aqualish", 6, "Ando");
        kvp = new KeyValuePair (info.name, info);
        map.add (kvp);

        // This is more compact: create the instance in the method argument list.
        info = new TribeInfo ("Gungan", 2, "Naboo");
        map.add ( new KeyValuePair (info.name, info) );

        info = new TribeInfo ("Amanin", 8, "Maridun");
        map.add ( new KeyValuePair (info.name, info) );

        info = new TribeInfo ("Jawa", 6, "Tatooine");
        map.add ( new KeyValuePair (info.name, info) );

        info = new TribeInfo ("Hutt", 7, "Varl");
        map.add ( new KeyValuePair (info.name, info) );

        // A little harder to read, but even more compact:
        map.add ( new KeyValuePair ("Cerean", new TribeInfo ("Cerean", 4, "Cerea") ) );

        KeyValuePair kvpResult = map.getKeyValuePair ("Hutt");
        System.out.println ("Info for Hutt: " + kvpResult);

        map.printBucketDistribution ();
    }

}
