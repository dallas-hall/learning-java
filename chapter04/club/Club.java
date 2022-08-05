import java.util.ArrayList; //ex 4.40
import java.util.Iterator; //ex 4.56

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> members; //ex 4.40
    private int membershipNumbers = 0;
    private ArrayList<Membership> purgedMembers = new ArrayList<Membership>(); //ex 4.55
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        members = new ArrayList<Membership>(); //ex 4.40
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member) //ex 4.42
    {
        members.add(member); //add the new member object to the members arraylist
        membershipNumbers++; //increment the membership numbers variable
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers() //ex 4.41
    {
        return membershipNumbers;
    }
    
     public int numberOfMembersv2() //ex 4.41
    {
        return members.size();
    }
    
    /** ex 4.54
     * determine number of members who joined in the inputted month.
     * @param month: the month we are interested in
     * @param stats: the stats of how many members joined, starts at 0
     * @return The number of members that month
     * 
     */
    
    public int joinedInMonth(int month)
    {
        int stats = 0;
        
        if (month < 1 || month > 12) {
            System.out.println("Month " + month + " out of range. Must be in the range 1 ... 12");
            return stats;
        }
        
        
        for (Membership member : members) {
            int monthCheck = member.getMonth();
            if (monthCheck == month)
            {
                stats++;
            }
        }
        System.out.println("The club had " + stats + " members join in month number: " + month);
        return stats;
    }
    
    /** ex 4.55
     * remove from the club's collection all members who joined in the given month, and return
     * them stored in a separate collection object.
     * @param month - the month of membership
     * @param year - year of membership
     * @return - the members that joined in the month and year provided
     */
    
    public ArrayList<Membership> purge(int month, int year)
    {
        if (month < 1 || month > 12) { //check if input is valid
            System.out.println("Month " + month + " out of range. Must be in the range 1 ... 12");
            return  null;
        }
        
        //ArrayList<Membership> purged = new ArrayList<Membership>();
        //create new ArrayList holding Membership objects in ArrayList called purged
        
        /*
         * this causes java.util.ConcurrentModificationException because we didnt use an iterator
         * 
         *
         * for (Membership member : members) {
         * int monthCheck = member.getMonth();
         * int yearCheck = member.getYear();
         * if (monthCheck == month && yearCheck == year) {
         *     purged.add(member);\
         *     members.remove(member);\
         *     }
         * }
         * return purged;
         */
        
        Iterator<Membership> it = members.iterator();
        int purgedNumber = 0;
        /*
         * create Iterator object expecting Membership objects in variable it for members collection
         * call iterator method 
         */
        System.out.println("Purging members based on input month:" + month + " and year: " + year);
        while (it.hasNext()) { //while the members collection has another object in the ArrayList
            Membership selectedMember = it.next(); //call the next Membership object, store it
            int monthCheck = selectedMember.getMonth(); //call the stored objects method
            int yearCheck = selectedMember.getYear(); //call the stored objects method
            
            if (monthCheck == month && yearCheck == year) { //check to see if object matchs input
                purgedMembers.add(selectedMember); //add to purged ArrayList
                it.remove(); //deleted from Iterator and members ArrayList.
                membershipNumbers--;
                purgedNumber++;
            }
        }
        System.out.println("Finished purging. " + purgedNumber + " member/s purged.");
        return purgedMembers; //return the purged ArrayList
    }
    
    public void purgedMembers() {
        Iterator<Membership> it = purgedMembers.iterator();
        while (it.hasNext()) {
            Membership selectedMember = it.next(); //call the next Membership object, store it
            System.out.println("THis member is currently purged " + selectedMember.getName() + ", "
                                + selectedMember.getMonth() + ", " + selectedMember.getYear());
        }
    }
}
