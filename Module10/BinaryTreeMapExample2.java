
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

} //end-TribeInfo


public class BinaryTreeMapExample2 {

    public static void main (String[] argv)
    {
        // Create an instance.
        BinaryTreeMap2 tree = new BinaryTreeMap2 ();

        // Put some key-value pairs inside.
        TribeInfo info = new TribeInfo ("Ewok", 3, "Endor");
        tree.add ("Ewok", info);

        info = new TribeInfo ("Aqualish", 6, "Ando");
        tree.add (info.name, info);

        info = new TribeInfo ("Gungan", 2, "Naboo");
        tree.add (info.name, info);

        info = new TribeInfo ("Amanin", 8, "Maridun");
        tree.add (info.name, info);

        info = new TribeInfo ("Jawa", 6, "Tatooine");
        tree.add (info.name, info);

        info = new TribeInfo ("Hutt", 7, "Varl");
        tree.add (info.name, info);

        info = new TribeInfo ("Cerean", 4, "Cerea");
        tree.add (info.name, info);

        // Note: a cast is needed for conversion from Object to TribeInfo
        // even though we know that a TribeInfo instance will be returned.
        TribeInfo tInfo = (TribeInfo) tree.getValue ("Hutt");
        System.out.println ("Info for Hutt: " + tInfo);

	String s = (String) tree.getValue("Hutt");
	System.out.println("Info for Hutt: " + s);
    }

}
