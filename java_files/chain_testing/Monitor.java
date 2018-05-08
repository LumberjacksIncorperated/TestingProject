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
import java.util.*;

public class Monitor {
	
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static Monitor globalMonitor = new Monitor("Monitor");

	private ArrayList<String> actionLog = new ArrayList<String>();
	private boolean isMonitoring = false;
	private final String monitorDescription;
	
	public static Monitor startGlobalMonitoringOnANewMonitorWithMonitorDescription(String monitorDescription) {
		globalMonitor = new Monitor(monitorDescription);
		globalMonitor.startMonitoring();
		return globalMonitor;
	}

	public static void stopGlobalMonitoring() {
		Monitor globalMonitor = Monitor.getCurrentGlobalMonitor();
		globalMonitor.stopMonitoring();
	}

	public static Monitor getCurrentGlobalMonitor() {
		return globalMonitor;
	}

	public boolean isMonitoring() {
		return this.isMonitoring;
	}

	public void checkIfMonitorLogContainsGivenMonitorLog(Monitor expectedCallLog) {
		boolean testedCallLogContainsExpectedCallLog = checkActionLog1ContainsActionLog2(this.actionLog, expectedCallLog.actionLog);
		if(testedCallLogContainsExpectedCallLog) {
			testSuccessWithLogs(this, expectedCallLog);
		} else {
			testFailureWithLogs(this, expectedCallLog);
		}
	}

		private void testSuccessWithLogs(Monitor testCallLog, Monitor expectedCallLog) {
			System.out.println("\n******************************************************************");
			System.out.println("****************** Test Success With Logs: ***********************");
			System.out.println("******************************************************************");
			printFormattedLogs(testCallLog, expectedCallLog);
			System.out.println("******************************************************************\n");
		}

		private void testFailureWithLogs(Monitor testCallLog, Monitor expectedCallLog) {
			System.out.println("\n******************************************************************");
			System.out.println("****************** Test Success With Logs: ***********************");
			System.out.println("******************************************************************");
			printFormattedLogs(testCallLog, expectedCallLog);
			System.out.println("******************************************************************\n");
		}

		private void printFormattedLogs(Monitor testCallLog, Monitor expectedCallLog) {
			//System.out.println("	"+testCallLog.monitorDescription);
			printFormattedActionLogForMonitor(testCallLog);
			//System.out.println("	"+expectedCallLog.monitorDescription);
			printFormattedActionLogForMonitor(expectedCallLog);
		}

		private boolean checkActionLog1ContainsActionLog2(ArrayList<String> actionLog1, ArrayList<String> actionLog2) {
			ActionLogComparator actionLogComparator = new ActionLogComparator(actionLog1, actionLog2);
			boolean actionLog1ContainsActionLog2 = actionLogComparator.checkLog1ContainsLog2();
			return actionLog1ContainsActionLog2;
		}

	public void monitorActionWithDescription(String actionDescription) {
		if (this.isMonitoring()) {
			this.pushActionIntoActionLog(actionDescription);
		}
	}

		private Monitor(String monitorDescription) {
			this.monitorDescription = monitorDescription;
		}

		private void startMonitoring() {
			this.isMonitoring = true;
		}

		private void stopMonitoring() {
			this.isMonitoring = false;
		}

		private void pushActionIntoActionLog(String actionDescription) {
			this.actionLog.add(actionDescription);
		}

		private void printFormattedActionLogForMonitor(Monitor monitor) {
			printBeautifullyFormattedString("Monitor ["+monitor.monitorDescription+"] Log");
			monitor.printActionLogDescription();
			System.out.println("");
		}

		private static void printBeautifullyFormattedString(String stringToPrint) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("	"+ stringToPrint +"		    			         	  ");
			System.out.println("-------------------------------------------------------------------------------");		
		}

		private void printActionLogDescription() {
			for (String actionLogEntry : this.actionLog) {
				System.out.println("[ACTION]: " + actionLogEntry);
			}
		}

	public class ActionLogComparator {
		
		private ArrayList<String> actionLog1;
		private ArrayList<String> actionLog2;
		private int actionLog1Index = 0; 
		private	int actionLog2Index = 0; 
		private boolean actionLog1ContainsActionLog2;

		public ActionLogComparator(ArrayList<String> actionLog1, ArrayList<String> actionLog2) {
			this.actionLog1 = actionLog1;
			this.actionLog2 = actionLog2;
		}

		public boolean checkLog1ContainsLog2() {
			this.runCheckingProcedure();
			this.getCheckingProcedureResults();
			return this.actionLog1ContainsActionLog2;
		}

			private void runCheckingProcedure() {
				for (this.actionLog1Index = 0; this.actionLog1Index < this.actionLog1.size(); this.actionLog1Index++) {
					checkElementOfLog1AgaintCurrentElementOfLog2();
				}
			}

			private void checkElementOfLog1AgaintCurrentElementOfLog2() {
				String actionLogOneEntryDescription = this.actionLog1.get(this.actionLog1Index);
				String actionLogOTwoEntryDescription = this.actionLog2.get(this.actionLog2Index);
				if(actionLogOneEntryDescription.equals(actionLogOTwoEntryDescription)) {
					this.actionLog2Index++;
				}
			}

			private void getCheckingProcedureResults() {
				if(this.actionLog2Index == (this.actionLog2.size())) {
					this.actionLog1ContainsActionLog2 = true;
				} else {
					this.actionLog1ContainsActionLog2 = false;
				}
			}
	}
}