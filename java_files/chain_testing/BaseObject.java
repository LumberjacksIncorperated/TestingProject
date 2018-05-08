//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Chain Testings Project"
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
import java.awt.*;
import java.util.*;

public class BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	public String getStringDescriptionOfMonitoredInformation() {
		exitWithErrorUntilOverwritten();
		return null;
	} 

	private void exitWithErrorUntilOverwritten() {
		System.out.println("This Object has not implemented getStringDescriptionOfMonitoredInformation");
		System.exit(0);
	}

	public void monitorMethodCallWithNameAndObjects(String methodCallIdentifier, BaseObject[] methodCallParameters) {
		Monitor currentGlobalMonitor = Monitor.getCurrentGlobalMonitor();
		if (currentGlobalMonitor.isMonitoring()) {
			ArrayList<BaseObject> methodCallParametersInArrayListForm = new ArrayList<BaseObject>(Arrays.asList(methodCallParameters));
			sendInformationToMonitor(currentGlobalMonitor, methodCallIdentifier, methodCallParametersInArrayListForm);
		}
	}

		private void sendInformationToMonitor(Monitor currentGlobalMonitor, String methodCallIdentifier, ArrayList<BaseObject> methodCallParameters) {
			String stringDescriptionOfMethodCallParameters = this.serializeMethodCallParametersIntoStringDescription(methodCallParameters);
			String methodCallDescriptionInMonitorFormat = methodCallIdentifier + ":::" + stringDescriptionOfMethodCallParameters;
			currentGlobalMonitor.monitorActionWithDescription(methodCallDescriptionInMonitorFormat);
		}

		private String serializeMethodCallParametersIntoStringDescription(ArrayList<BaseObject> methodCallParameters) {
			String stringDescriptionOfMethodCallParameters = "";
			for (BaseObject methodCallParamter : methodCallParameters) {
				stringDescriptionOfMethodCallParameters += getFormattedDescriptionOfMethodCallParameter(methodCallParamter);
			}
			return stringDescriptionOfMethodCallParameters;
		}

		private String getFormattedDescriptionOfMethodCallParameter(BaseObject methodCallParameter) {
			String methodCallDescriptionString = methodCallParameter.getStringDescriptionOfMonitoredInformation();
			String formattedDescriptionString = "|" + methodCallDescriptionString + "|";
			return formattedDescriptionString;
		}
}