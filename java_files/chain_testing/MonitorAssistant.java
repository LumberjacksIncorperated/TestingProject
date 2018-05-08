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

public class MonitorAssistant {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
        System.out.println("< Performing Test: "+testDescription+" >");
        runTestOnNewThreadWithMonitorAssistantDelegate(monitorAssitentDelegate, testDescription);
    }

        private static void runTestOnNewThreadWithMonitorAssistantDelegate(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) { 
            try {
                Thread testingThread = createTestThreadWithDelegateAndDescription(monitorAssitentDelegate, testDescription);
                testingThread.start();
                testingThread.join();
            } catch (Exception e) {
                System.out.println("<<< ERROR (Class: MonitorAssistant Method: runTestOnNewThreadWithMonitorAssistantDelegate)>>>");
                System.exit(1);
            } 
        }

        private static Thread createTestThreadWithDelegateAndDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
            Thread testingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    MonitorAssistant.runTestWithMonitorAssistantDelegate(monitorAssitentDelegate, testDescription);
                }
            });
            return testingThread;
        }

        private static void runTestWithMonitorAssistantDelegate(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
            Monitor testedCallsMonitor = executeTestCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(monitorAssitentDelegate, testDescription);
            Monitor expectedCallsMonitor = executeExpectedCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(monitorAssitentDelegate, testDescription);
            testedCallsMonitor.checkIfMonitorLogContainsGivenMonitorLog(expectedCallsMonitor);
            //System.exit(0);
        }

        private static Monitor executeTestCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
            Monitor testedCallsMonitor = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Tested - " + testDescription);
            monitorAssitentDelegate.executeTestCalls();
            Monitor.stopGlobalMonitoring();
            return testedCallsMonitor;
        }

        private static Monitor executeExpectedCallsOnDelegateAndReturnCorrespondingMonitorWithDescription(MonitorAssistantDelegate monitorAssitentDelegate, String testDescription) {
            Monitor expectedCallsMonitor = Monitor.startGlobalMonitoringOnANewMonitorWithMonitorDescription("Expected - " + testDescription);
            monitorAssitentDelegate.executeExpectedCalls();
            Monitor.stopGlobalMonitoring();      
            return expectedCallsMonitor; 
        }
}
    	