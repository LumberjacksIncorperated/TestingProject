//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Chain Testing Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// PACKAGE 
//-----------------------------------------------------------------------------------------------------------------------
package chain_testing;

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
// <NONE>

public class ObjectDescription extends BaseObject {
	
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private final String description;

	public ObjectDescription(String description) {
		this.description = description;
	} 

	public String getStringDescriptionOfMonitoredInformation() {
		return this.description;
	}

	public static ObjectDescription descriptionOfInt(int integer) {
		return new ObjectDescription(String.valueOf(integer));
	}

	public static ObjectDescription descriptionOfString(String string) {
		return new ObjectDescription(string);
	}

	public static ObjectDescription descriptionOfBoolean(Boolean booleanValue) {
		return new ObjectDescription(String.valueOf(booleanValue));
	}
}