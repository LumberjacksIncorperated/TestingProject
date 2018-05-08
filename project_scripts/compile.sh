#!/bin/sh

#----------------------------------------------------------------------------------------------------------------------
#
# PROJECT
# -------
# Chain Testing Project
#
# AUTHOR
# ------
# Lumberjacks Incorperated (2018)
#
#----------------------------------------------------------------------------------------------------------------------

#----------------------------------------------------------------------------------------------------------------------
# MAIN
#----------------------------------------------------------------------------------------------------------------------
main()
{
    echo "<START>"
    
    echo "Enter compilation starting directory"
    enterCompilationStartingDirectory
    
    echo "Compile java files"
    compileJavaFiles
    
    echo "Cleanup Project"
    moveClassFilesInClassFilesDirectory
    
    echo "<DONE>"
}

#----------------------------------------------------------------------------------------------------------------------
# INTERNAL FUNCTIONS
#----------------------------------------------------------------------------------------------------------------------
function enterCompilationStartingDirectory()
{
    cd ../java_files/
}

function compileJavaFiles()
{
	javac chain_testing/BaseObject.java
	javac chain_testing/Monitor.java
	javac chain_testing/MonitorAssistant.java
	javac chain_testing/MonitorAssistantDelegate.java
	javac chain_testing/ObjectDescription.java
	javac chain_testing/ChainTestingTest.java
}

function moveClassFilesInClassFilesDirectory()
{
	mkdir ../class_files/chain_testing
	mv ./chain_testing/*.class ../class_files/chain_testing/
}

#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main