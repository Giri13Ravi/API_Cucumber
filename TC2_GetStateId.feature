@State

Feature: State module API Automation

Scenario: verify user get Statelist through api
Given user add headers for statelist
When user send "GET" request for statelist endpoint
Then User should verify the status code is 200
And user should verify the statelist response message matches "Tamil Nadu" and saved stateid
