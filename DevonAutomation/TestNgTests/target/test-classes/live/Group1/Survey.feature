@Survey   
Feature: Survey

########################################################################################################

Scenario: As a user I want to create and validate survey
Given a user logs into the agile cockpit 
When creates a survey
Then newly created survey should be present in the system
