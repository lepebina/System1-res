@Keywords
Feature: Keywords aliases test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

#@target-alias-H1-1
 @new-framework
  Scenario: Subscribed user sends mo with INFO alias to free short code
    Given User has "355006710023" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "INFO" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_HELP" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
    
    
     @new-framework
    Scenario:  Request of subscription information by a subscribed user.-15
	Given msisdn "355006710023"
	And User with no profile
	When "YES" sms is sent by the user
	Then A profile is created
	When "INFO" sms is sent by the user
	Then A "SUBSCRIPTION_HELP" request is created
	And "subscrition_1_help" text message is received by the user from the "RESPONSE_SUBSCRIPTION_SERVICE"

#@target-alias-H1-2
 @new-framework
  Scenario: Subscribed user sends mo with QUIT to free short code
    Given User has "355006740004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "QUIT" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request
    
   
     @new-framework
    Scenario: A subscribed user sends a free short code messages-15
	Given "355006740004" msisdn is the identification code for the user with no profile
	When A "YES" sms  is sent by the user
	Then The profile is created
    When The same user sends a "QUIT" sms
    Then The user will be unsubscribed from the profile
    And A request is sent to "UNSUBSCRIBED" in response to the sms 

  @original-keyword-aliases-1
  Scenario: Subscribed user sends mo with CANCEL to free short code
    Given User has "355006750004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "CANCEL" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request

  @original-keyword-aliases-2
  Scenario: Subscribed user sends mo with OFF to free short code
    Given User has "355006760004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "OFF" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request

#@target-alias-H1-3
 @new-framework
  Scenario: A Subscribed user sends mo with QUIT to free short code
    Given User has "355006770004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "ACT" to free short code
    Then Sms is being processed by the "ACTIVITY" request
    
    
     @new-framework
   Scenario: Free short code messages is sent by a subscribed user-15
	Given Unprofiled user identification msisdn of "355006770004"
	When A sms of the following code is sent "YES"
	Then User profile is created
	When A sms of the following code is sent "ACT"
	Then "ACTIVITY" request processes the message sent
