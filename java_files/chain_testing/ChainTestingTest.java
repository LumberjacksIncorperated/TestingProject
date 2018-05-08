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
// <none>

public class ChainTestingTest extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // MAIN
    //-----------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		ChainTestingTest.runTests();
	}

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private ChainTestingTest() {}

	public void testCallOne(int arg1, int arg2, int arg3) {
		this.monitorMethodCallWithNameAndObjects("testCallOne()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(arg1),
			ObjectDescription.descriptionOfInt(arg2),
			ObjectDescription.descriptionOfInt(arg3)
		});

		Endpoint endpoint = new Endpoint();
		endpoint.fakeCallOne(arg1, arg2);
	}

	public void testCallTwo(int arg1, int arg2) {
		this.monitorMethodCallWithNameAndObjects("testCallTwo()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(arg1),
			ObjectDescription.descriptionOfInt(arg2)
		});

		Endpoint endpoint = new Endpoint();
		endpoint.fakeCallTwo(arg1, arg2);
	}

	public void testCallThree(int arg1, int arg2) {
		this.monitorMethodCallWithNameAndObjects("testCallThree()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(arg1),
			ObjectDescription.descriptionOfInt(arg2)
		});

		Endpoint endpoint = new Endpoint();
		endpoint.fakeCallThree(arg1, arg2);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static void runTests() {
		runTestOne();
		runTestTwo();
		runTestThree();
	}

	public static void runTestOne() {
		MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				ChainTestingTest chainTestingTest = new ChainTestingTest();
				chainTestingTest.testCallOne(1, 2, 3);
    		}

    		public void executeExpectedCalls() {
    			Endpoint newEndpoint = new Endpoint();
    			newEndpoint.fakeCallOne(1, 2);
    		}

    	}, "Test One");
	}

	public static void runTestTwo() {
		MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				ChainTestingTest chainTestingTest = new ChainTestingTest();
				chainTestingTest.testCallTwo(1, 2);
    		}

    		public void executeExpectedCalls() {
    			Endpoint newEndpoint = new Endpoint();
    			newEndpoint.fakeCallTwo(1, 2);
    		}

    	}, "Test Two");
	}

	public static void runTestThree() {
		
		MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				ChainTestingTest chainTestingTest = new ChainTestingTest();
				chainTestingTest.testCallThree(1, 2);
    		}

    		public void executeExpectedCalls() {
    			Endpoint newEndpoint = new Endpoint();
    			newEndpoint.fakeCallThree(1, 2);
    		}

    	}, "Test Three");
	}

	public static class Endpoint extends BaseObject {

		public Endpoint() {}

		public void fakeCallOne(int arg1, int arg2) {
			this.monitorMethodCallWithNameAndObjects("fakeCallOne()", new BaseObject[] {
				ObjectDescription.descriptionOfInt(arg1),
				ObjectDescription.descriptionOfInt(arg2)
			});
		}

		public void fakeCallTwo(int arg1, int arg2) {
			this.monitorMethodCallWithNameAndObjects("fakeCallTwo()", new BaseObject[] {
				ObjectDescription.descriptionOfInt(arg1),
				ObjectDescription.descriptionOfInt(arg2)
			});
		}

		public void fakeCallThree(int arg1, int arg2) {
			this.monitorMethodCallWithNameAndObjects("fakeCallThree()", new BaseObject[] {
				ObjectDescription.descriptionOfInt(arg1),
				ObjectDescription.descriptionOfInt(arg2)
			});
		}
	}
}