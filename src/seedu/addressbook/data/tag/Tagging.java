package seedu.addressbook.data.tag;
import java.util.ArrayList;
import seedu.addressbook.data.person.ReadOnlyPerson;;

/**
 * Represents a tagging in the address book entry.
 * 
 *
 */
public class Tagging {
	private ArrayList<String> taggings;
	
	public Tagging() {
		taggings = new ArrayList<String>();
	}
	
	public void addTagging(String tag, ReadOnlyPerson targetPerson) {
		taggings.add("+ " + targetPerson.getName().toString() + " [" + tag + "]");
	}
	
	public void removeTagging(String tag, ReadOnlyPerson targetPerson) {
		taggings.add("- " + targetPerson.getName().toString() + " [" + tag + "]");
	}
	

}
