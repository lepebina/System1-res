@Teaser @Content
Feature: Content teaser test cases

  Background: Start a fresh test
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "7" free days and welcome message from free shorcode
    And Refresh cache

@original-content-1
  Scenario: User with profile receives free content teaser
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-26"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "5" is triggered
#      And User receives the "<string>" reply from free short code

 #@target-content-H1-1
  @new-framework
  Scenario: User with no profile does not receives free content teaser
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-26"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "5" is triggered
    And User does not receive subscription content 
    
    #@injected-content-H1-1 
     @new-framework
    Scenario: User with no profile does not receives free content teaser-9
    Given User has "355123123000" msisdn
    And User has no profile 
    And User current time is "-26"
    When User sends SMS with text and freeing teaser "5" is triggered 
    Then User has profile 
    And update current time to "0"
    And User does not receive subscription content   
    
    
    #@injected-content-H1-2
     @new-framework
    Scenario: Not sending subscription content-3
    Given User with "355123123000" msisdn
    And No user's profile
    And "-26" current time
    When Sms containing "YES" input is sent by the user
    Then Create user profile
    And "0" current time
    When Triggering freeing teaser "5"
    And Subscription content are not received by the user

 @original-content-2
  Scenario: User with profile receives billed content teaser
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "4" is triggered
#      And User receives the "<string>" reply from free short code

  @original-content-3
  Scenario: User with no profile does not receives billed content teaser
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "4" is triggered
    And User does not receive subscription content

    #invalid scenarios
  @original-content-4
  Scenario: User with no profile does not receives billed content teaser in free period
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "5" is triggered
    And User does not receive subscription content

  #@target-content-H1-2
   @new-framework
  Scenario: User with no profile does not receives free content teaser in billed period
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-26"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And Current time is "0"
    When Freeing teaser "4" is triggered
    And User does not receive subscription content
    
    #@injected-content-H1-3
     @new-framework
    Scenario: None users should not receive free content-4
    Given User has "355123123000" msisdn
    And User has no user account
    And Current time is "-26"
    When User sends sms with the text "YES" to free short code
    Then User has account 
    And Current time is "0"
    When Freeing teaser "5" is activated 
    And User does not receive subscription content
    
  @original-content-5
  Scenario: User with profile receives correct content regarding the subscription day
    Given User has "355123123000" msisdn
    And User has no profile
    And Current time is "-192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-168"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-144"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-120"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-96"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-72"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-48"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "-24"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code
    And Current time is "0"
    When Freeing teaser "5" is triggered
#        Then User receives the "<string>" reply from free short code

