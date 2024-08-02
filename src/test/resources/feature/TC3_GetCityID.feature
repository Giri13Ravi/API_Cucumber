@City

Feature: City module API Automation
Scenario: verify user get citylist through api

Given user add header for citylist name
When user add request body stateid for get citylist
And user send "POST" request for citylist endpoint
Then User should verify the status code is 200
And user should verify the city list response message matches "Mayiladuthurai" and saved cityid