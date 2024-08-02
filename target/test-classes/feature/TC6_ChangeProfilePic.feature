@ChangeProPic

Feature: ChangeProfilePic module API Automation
Scenario: verify user get ChangeProfilePic through api

Given user add header and bearer authorization for accessing ChangeProfilePic endpoints
When user add formdata for ChangeProfilePic
And user send "POST" request for ChangeProfilePic endpoint
Then User should verify the status code is 200
And user should verify the ChangeProfilePic response message matches "Profile updated Successfully"